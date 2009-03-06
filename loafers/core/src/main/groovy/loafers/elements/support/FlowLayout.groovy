package loafers.elements.support;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import loafers.elements.Element;
import loafers.elements.Slot;


/**
 * Copy of java.awt.FlowLayout, but uses styles to determine size of components
 * 
 * @author Peter De Bruycker
 */
public class FlowLayout extends LayoutBase {

	public Dimension preferredLayoutSize(Container target) {
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			Dimension dim = new Dimension();

			// calculate the preferred size with wrapping
			if (target.getWidth() > 0) {
				int maxwidth = target.getWidth() - (insets.left + insets.right);

				int nmembers = target.getComponentCount();
				int x = 0;
				int y = insets.top;
				int rowh = 0;

				for (int i = 0; i < nmembers; i++) {
					Component m = target.getComponent(i);

					if (m.isVisible()) {
						Dimension d = determineSize(target, m);
						
						Insets margin = determineMargin(target, m);

						if ((x == 0) || ((x + margin.left + d.width + margin.right) <= maxwidth)) {
							x += margin.left + d.width + margin.right;
							rowh = Math.max(rowh, margin.top + d.height + margin.bottom);
						} else {
							x = margin.left + d.width + margin.right;
							y += rowh;
							rowh = margin.top + d.height + margin.bottom;
						}
					}
				}

				// 4 comes from the insets, there's an error somewhere
				dim.width = maxwidth + 4;
				dim.height = y + rowh;
			} else {
				// preferred size in one row
				for (Component m : target.getComponents()) {
					if (m.isVisible()) {
						Dimension d = determineSize(target, m);

						Insets margin = determineMargin(target, m);

						dim.height = Math.max(dim.height, margin.top + d.height + margin.bottom);
						dim.width += margin.left + d.width + margin.right;
					}
				}
			}

			dim.width += insets.left + insets.right;
			dim.height += insets.top + insets.bottom;

			return dim;
		}
	}

	private void moveComponents(Container target, int x, int y, int width,
			int rowStart, int rowEnd) {
		for (int i = rowStart; i < rowEnd; i++) {
			Component m = target.getComponent(i);
			if (m.isVisible()) {
				Insets margin = determineMargin(target, m);				
				
				m.setLocation(x+margin.left, y+margin.right);
				x += m.getWidth()+margin.right;
			}
		}
	}

	public void layoutContainer(Container target) {
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			int maxwidth = target.getWidth() - (insets.left + insets.right);
			int maxheight = target.getHeight() - (insets.top + insets.bottom);

			int nmembers = target.getComponentCount();
			int x = insets.left;
			int y = insets.top;
			int rowh = 0;
			int start = 0;

			// this is needed to set the height of all slots to the height of
			// their row (if they have no height style)
			Map<Component, Dimension> slotsOnCurrentRow = new HashMap<Component, Dimension>();

			for (int i = 0; i < nmembers; i++) {
				Component m = target.getComponent(i);

				if (m.isVisible()) {
					Dimension d = determineSize(target, m);

					Insets margin = determineMargin(target, m);
					
					if ((x == 0) || ((x + margin.left + d.width + margin.right) <= maxwidth)) {
						x += margin.left + d.width + margin.right;
						rowh = Math.max(rowh, margin.top + d.height + margin.bottom);
					} else {
						setHeightOnSlots(slotsOnCurrentRow, rowh);

						// wrap
						moveComponents(target, insets.left, (int)y, (int)(maxwidth - x),
								(int)start, i);
						x = insets.left + margin.left + d.width + margin.right;
						y += rowh;
						rowh = margin.top + d.height + margin.bottom;
						start = i;
					}

					Element constraints = getConstraints(m);
					if (constraints instanceof Slot && constraints.styles().get("height") == null) {
						if(nmembers == 1) {
							d.width = maxwidth;
						}

						slotsOnCurrentRow.put(m, d);
					}
					
					m.setSize((int)d.getWidth(), (int)d.getHeight());
				}
			}

			setHeightOnSlots(slotsOnCurrentRow, maxheight - y);

			moveComponents(target, insets.left, (int)y, (int)(maxwidth - x), (int)start,
					nmembers);
		}
	}

	private void setHeightOnSlots(Map<Component, Dimension> slots, int height) {
		// this is needed to set the height of all slots to the height of their
		// row
		for (Map.Entry<Component, Dimension> entry : slots.entrySet()) {
			Dimension size = entry.getValue();
			size.height = height;
			entry.getKey().setSize(size);
		}
		slots.clear();
	}
}
