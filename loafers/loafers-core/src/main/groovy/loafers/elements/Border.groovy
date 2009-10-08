package loafers.elements;

import java.awt.BasicStroke
import java.awt.Graphics2Dimport java.awt.Dimension

/**
 * A border goes round a Slot
 */
public class Border extends PaintElement {

    protected void doPaint(Slot parent, Graphics2D g) {
        def bounds = parent.panel.bounds
        def parentSize = bounds.getSize()
        def size = calculateSize(parentSize)
 
        int strokeWidth = styles.strokewidth ? styles.strokewidth : 1

        g.setStroke(new BasicStroke((float)strokeWidth))
        g.drawRect((int)strokeWidth/2, (int)strokeWidth/2, (int)size.width - strokeWidth, (int)size.height - strokeWidth)
    }
    
    protected Dimension getPreferredSize(Dimension parentSize) {
    	return parentSize
    }
    
}
