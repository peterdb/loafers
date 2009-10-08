package loafers.elements;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;

import loafers.paint.Pattern;

/**
 * Element that needs to be painted, such as Background or Border.
 * <p>
 * A PaintElement has a Pattern that will be used for painting.
 * 
 * @author Peter De Bruycker
 */public abstract class PaintElement extends Element {

    private boolean visible = true
    
    private Pattern pattern
    
    protected void doStyle(Map styles) {
        // TODO pattern can also be a string, original must be kept in the styles map, pattern should become a Pattern instance
        if(styles.containsKey('pattern')) {
            pattern = styles.pattern
        }
        
        parent?.update()
    }
    
    public void setPattern(Pattern pattern) {
        style(["pattern":pattern])
    }

    public Pattern getPattern() {
        return pattern
    }
    
	public hide() {
		visible = false
		parent?.update()
	}
	
	public show() {
		visible = true
		parent?.update()
	}
	
	public toggle() {
		visible = !visible
		parent?.update()
	}
	
	protected void paint(Slot parent, Graphics2D g) {
	    if(visible && pattern != null) {
            g.paint = pattern.createPaint(size)
	        
	        doPaint(parent, g)
	    }
	}

	protected abstract void doPaint(Slot parent, Graphics2D g)

	public Dimension getSize() {
	    def bounds = parent.panel.bounds
        def parentSize = bounds.getSize()
        
        return calculateSize(parentSize)
    }
}
