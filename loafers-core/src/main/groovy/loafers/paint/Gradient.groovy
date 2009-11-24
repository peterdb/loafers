package loafers.paint;

import java.awt.Color
import java.awt.Graphics
import java.awt.Paint;
import java.awt.Dimension;

import loafers.elements.PaintElement;

/**
 * A gradient pattern.
 * 
 * @author Peter De Bruycker
 */
public class Gradient implements Pattern {

    private int angle
    
    private Color color1
    private Color color2

    public Gradient(Color color1, Color color2, int angle) {
        assert color1 != null
        assert color2 != null
        
        this.color1 = color1
        this.color2 = color2
        
        this.angle = angle;
    }
    
    public Gradient(Color color1, Color color2) {
        this(color1, color2, 0)
    }

    public Paint createPaint(Dimension size) {
        // TODO rotate the gradient
        
        return new java.awt.GradientPaint(0.0f, 0.0f, color1, 0.0f, (float)size.height, color2)
    }
    
}
