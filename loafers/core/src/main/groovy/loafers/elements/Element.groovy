package loafers.elements

import java.awt.Dimensionimport java.awt.Insetsimport loafers.Stylableimport java.math.BigDecimal
import java.awt.Pointpublic abstract class Element implements Stylable {
	private Slot parent
	private Map styles = [:]
	
	public setParent(Slot slot) {
		parent = slot
	}
	
	public Slot getParent() {
		return parent
	}
	
	public abstract hide()
	
	public abstract show()
	
	public abstract toggle()
	
	public remove() {
		parent.remove(this)
		parent = null
	}
	
	public void style(Map styles) {
		assert styles != null : "styles cannot be null"
		
		if(styles.hidden != null) {
			if(styles.hidden) {
				hide()
			}else {
				show()
			}
		}
		
		// force a layout of the parent
		if(styles.height != null || styles.width != null) {
			parent?.update()
		}
		
		this.styles.putAll(styles)
	}
	
	public void setWidth(width) {
		style(["width":width])
	}
	
	public Map styles() {
		return styles
	}
	
	public Dimension calculateSize(Dimension parentSize) {
		Dimension preferredSize = getPreferredSize(parentSize);
		if (styles().containsKey("width")) {
			preferredSize.width = processConstraint(styles().get("width"),
					(int)parentSize.width);
		}
		
		if (styles().containsKey("height")) {
			preferredSize.height = processConstraint(styles().get("height"),
					(int)parentSize.height);
		}
		
		return preferredSize;
	}
	
	protected Dimension getPreferredSize(Dimension parentSize) {
		return new Dimension(0,0)
	}
	
	public Insets calculateMargin(Dimension parentSize) {
		if (styles().containsKey("margin")) {
			Integer margin = (Integer) styles().get("margin");
			return new Insets(margin, margin, margin, margin);
		}

		return new Insets(0,0,0,0)
	}
	
	// TODO implement positioning
	public Point calculatePosition(Point location, Dimension parentSize) {
		if (styles().containsKey("right")) {
			Dimension size = calculateSize(parentSize);
			location.x = parentSize.width - styles().right
		}
		
		return location
	}
	
	private int processConstraint(Object constraint, int value) {
		if (constraint instanceof Integer) {
			int tmp = ((Integer) constraint).intValue();
			return tmp < 0 ? value + tmp : tmp
		}
		
		if (constraint instanceof String
		&& ((String) constraint).matches("\\d+")) {
			return Integer.parseInt((String) constraint);
		}
		
		if (constraint instanceof BigDecimal) {
			return (int) (((BigDecimal) constraint) * value);
		}
		
		if (constraint instanceof Float) {
			return (int) (((Float) constraint) * value);
		}
		
		if (constraint instanceof Double) {
			return (int) (((Double) constraint) * value);
		}
		
		if (constraint instanceof String) {
			if (((String) constraint).endsWith("%")) {
				if (value > 0) {
					String percentageString = (String) constraint;
					int percentage = Integer.parseInt(percentageString
							.substring(0, percentageString.length() - 1));
					// TODO percentage > 0 && percentage <= 100
					
					return (int) (((double) percentage / 100) * value);
				} else {
					return value;
				}
			}
		}
		
		throw new IllegalArgumentException("Invalid constraint " + constraint);
	}
	
}
