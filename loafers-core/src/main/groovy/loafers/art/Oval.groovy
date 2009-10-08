package loafers.art;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Map;
import java.awt.geom.Ellipse2D;

/**
 * @author Peter De Bruycker
 */
public class Oval extends AbstractShape {

    protected void doPaint(Graphics2D graphics) {
        Map styles = getStyles()
        
        assert styles.containsKey("radius") || styles.containsKey("width") && styles.containsKey("height"), "oval must either have a radius or have a width and height"
        
        int x = 0
        int y = 0
        int width = 0
        int height = 0

        if(styles.containsKey("radius")) {
            width = height = styles.radius
        } else {
            width = styles.width
            height = styles.height
        }

        if(styles.center) {
            x = styles.left - (width/2)
            y = styles.top - (height/2)
        } else {
            x = styles.left
            y = styles.top
        }

        Shape shape = new Ellipse2D.Float(x, y, width, height)

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
