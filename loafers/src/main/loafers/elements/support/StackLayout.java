package loafers.elements.support;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import loafers.elements.Element;
import loafers.elements.Slot;


public class StackLayout extends FlowLayout {
	
	public Dimension preferredLayoutSize(Container target) {
		synchronized (target.getTreeLock()) {
			Dimension dim = new Dimension();

			for (Component m : target.getComponents()) {
				if (m.isVisible()) {
					Dimension d = determineSize(target, m);
					
					dim.width = Math.max(dim.width, d.width);
					dim.height += d.height;
				}
			}
			
			Insets insets = target.getInsets();
			dim.width += insets.left + insets.right;
			dim.height += insets.top + insets.bottom;
			
			return dim;
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

					Element element = getConstraints(m);
					if(element instanceof Slot && element.styles().get("width") == null) {
						d.width = maxwidth;
					}
					
					m.setSize(Math.min(d.width, maxwidth), d.height);
					m.setLocation(x, y);
					
					y += d.height;
				}
			}
		}
	}
}
