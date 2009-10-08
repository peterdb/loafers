package loafers.elements.support;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import loafers.elements.Element;
import loafers.elements.Slot;

public class StackLayout extends LayoutBase {
	
	public Dimension preferredLayoutSize(Container target) {
		synchronized (target.getTreeLock()) {
			Dimension preferredSize = target.components.inject(new Dimension()) { dim, m ->
				if (m.isVisible()) {
					Dimension d = determineSize(target, m);
					
					Insets margin = determineMargin(target, m);
					
					dim.width = Math.max(dim.width, d.width + margin.left
							+ margin.right);
					dim.height += d.height + margin.top + margin.bottom;
				}
				
				return dim
			}
			
			Insets insets = target.getInsets();
			preferredSize.width += insets.left + insets.right
			preferredSize.height += insets.top + insets.bottom
						
			return preferredSize
		}
	}
	
	public void layoutContainer(Container target) {
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			int x = insets.top;
			int y = insets.top;
			int maxwidth = target.getWidth() - (insets.left + insets.right);
			
			for (Component m : target.getComponents()) {
				if (m.isVisible()) {
					Dimension d = determineSize(target, m);
                    Insets margin = determineMargin(target, m);
					
					Element element = getConstraints(m);
					if (element instanceof Slot && element.styles.get("width") == null) {
						d.width = maxwidth - (margin.left + margin.right);
					}
					
					y += margin.top;
					
					m.setSize((int)Math.min(d.width, maxwidth), (int)d.getHeight());
					m.setLocation((int)x + margin.left, (int)y);
					
					y += d.height + margin.bottom;
				}
			}
		}
	}
}
