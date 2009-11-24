package loafers.elements.support;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.HashMap;
import java.util.Map;

import loafers.elements.Element;

/**
 * Base for FlowLayout and StackLayout.
 * 
 * @author Peter De Bruycker
 */
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

	public Insets determineMargin(Container target, Component comp) {
		if (constraintsMap.containsKey(comp)) {
			Element element = constraintsMap.get(comp);
			Insets insets = target.getInsets();
			Dimension parentSize = target.getSize();

			parentSize.width = parentSize.width - insets.left - insets.right;
			parentSize.height = parentSize.height - insets.top - insets.bottom;
			
			return element.calculateMargin(parentSize);
		}

		return new Insets(0, 0, 0, 0);
	}

	public Dimension determineSize(Container target, Component comp) {
		if (constraintsMap.containsKey(comp)) {
			Element element = constraintsMap.get(comp);
//			Insets insets = target.getInsets();
			Dimension parentSize = target.getSize();

			Insets margin = determineMargin(target, comp)

			parentSize.width = parentSize.width - margin.left - margin.right;
			parentSize.height = parentSize.height - margin.top - margin.bottom;

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
