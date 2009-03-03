package loafers.elements.support;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.HashMap;
import java.util.Map;

import loafers.elements.Element;

public abstract class LayoutBase implements LayoutManager2 {

	private Map<Component, Element> constraintsMap = new HashMap<Component, Element>();

	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints != null) {
			constraintsMap.put(comp, (Element) constraints);
		}
	}

	public void addLayoutComponent(String name, Component comp) {
		// not used
	}

	public void removeLayoutComponent(Component comp) {
		constraintsMap.remove(comp);
	}

	public Dimension maximumLayoutSize(Container target) {
		return preferredLayoutSize(target);
	}

	public Dimension minimumLayoutSize(Container target) {
		return preferredLayoutSize(target);
	}

	public void invalidateLayout(Container target) {
		// not used
	}

	public Insets determineMargin(Component comp) {
		if (constraintsMap.containsKey(comp)) {
			Element element = constraintsMap.get(comp);
			if (element.styles().containsKey("margin")) {
				Integer margin = (Integer) element.styles().get("margin");
				return new Insets(margin, margin, margin, margin);
			}
		}

		return new Insets(0, 0, 0, 0);
	}

	public Dimension determineSize(Container target, Component comp) {
		if (constraintsMap.containsKey(comp)) {
			Element element = constraintsMap.get(comp);
			Insets insets = target.getInsets();
			Dimension parentSize = target.getSize();

			parentSize.width = parentSize.width - insets.left - insets.right;
			parentSize.height = parentSize.height - insets.top - insets.bottom;

			return element.calculateSize(parentSize);
		}

		return comp.getPreferredSize();
	}

	public float getLayoutAlignmentX(Container target) {
		// not used
		return 0f;
	}

	public float getLayoutAlignmentY(Container target) {
		// not used
		return 0f;
	}

	public Element getConstraints(Component m) {
		return constraintsMap.get(m);
	}

}
