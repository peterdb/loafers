package loafers.elements;

import java.util.Map;
import java.awt.Graphicsimport java.awt.Colorimport java.awt.Graphics2Dimport java.awt.Dimension

public class Background extends PaintElement {
    
    private Color color 
    
    public void style(Map styles) {
        super.style(styles);
        
        if(styles.color) {
            this.color = styles.color
        }
        
        parent?.update()
    }
    
    protected void paint(Slot parent, Graphics2D g) {
        if(color != null) {
            g.color = color
            def bounds = parent.panel.bounds
            def parentSize = bounds.getSize()
            def size = calculateSize(parentSize)
            
            g.fillRect((int)0, (int)0, (int)size.width, (int)size.height);
        }
    }
    
    protected Dimension getPreferredSize(Dimension parentSize) {
    	return parentSize
    }
    
}
