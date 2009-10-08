package loafers.paint;

import java.awt.Color
import java.awt.Graphics
import java.awt.Paint;
import java.awt.Dimension;

import loafers.elements.PaintElement;

/**
 * @author Peter De Bruycker
 */
public class Gradient implements Pattern {

    private Color color1
    private Color color2

    public Gradient(Color color1, Color color2) {
        assert color1 != null
        assert color2 != null
        
        this.color1 = color1
        this.color2 = color2
    }

    public Paint createPaint(Dimension size) {
        return new java.awt.GradientPaint(0.0f, 0.0f, color1, 0.0f, (float)size.height, color2)
    }
    
}
