package loafers.art;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.List;
import java.util.Map;

import loafers.paint.Pattern;

/**
 * @author Peter De Bruycker
 */
public abstract class AbstractShape {

    private Map styles = [:]
    
    Pattern fill
    Pattern stroke
    Integer strokeWidth

    // transformations
    boolean transformAtCorner = true
    Double rotation
    List translation
    
    public void paint(Graphics2D graphics) {
        Graphics2D g = graphics.create()

        if(strokeWidth != null) {
            g.setStroke(new BasicStroke(strokeWidth))
        }
        
        doPaint(g)

        g.dispose()
    }

    protected abstract void doPaint(Graphics2D graphics);

    public void style(Map styles) {
        assert styles != null, "styles cannot be null"

        this.styles.putAll(styles)
    }

    public Map getStyles() {
        return styles
    }
    
}
