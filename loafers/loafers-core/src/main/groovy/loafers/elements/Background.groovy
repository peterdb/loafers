package loafers.elements;

import java.awt.Graphics2Dimport java.awt.Dimension

public class Background extends PaintElement {

    protected void doPaint(Slot parent, Graphics2D g) {
        g.fillRect((int)0, (int)0, (int)size.width, (int)size.height)
    }
    
    protected Dimension getPreferredSize(Dimension parentSize) {
    	return parentSize
    }
    
}
