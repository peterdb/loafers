package loafers.art;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Map;
import java.awt.geom.Ellipse2D;

/**
 * @author Peter De Bruycker
 */
public class Rect extends AbstractShape {

    protected void doPaint(Graphics2D graphics) {
        Map styles = getStyles()
        
        int x = 0
        int y = 0
        int width = styles.width
        int height = styles.height

        if(styles.center) {
            x = styles.left - (width/2)
            y = styles.top - (height/2)
        } else {
            x = styles.left
            y = styles.top
        }

        Shape shape = null;
        
        if(styles.curve != null) {
            int curve = styles.curve
            
            shape = new RoundRectangle2D.Float(x, y, width, height, curve, curve)
        } else {
            shape = new Rectangle2D.Float(x, y, width, height)
        }
        
        if(fill != null) {
            graphics.paint = fill.createPaint(new Dimension(width, height))
            graphics.fill(shape)
            graphics.paint = null
        }

        if(stroke != null) {
            graphics.paint = stroke.createPaint(new Dimension(width, height))
            graphics.draw(shape)
            graphics.paint = null
        }
    }
    
}
