package loafers.elements;

import java.util.Map;
import java.awt.Graphics
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
            g.fillRect(0,0,parent.panel.width, parent.panel.height);
        }
    }
    
}