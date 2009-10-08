package loafers.paint

import java.awt.Graphics

import java.awt.Dimension;
import java.awt.Paint;

import loafers.elements.PaintElement;

/**
 * @author Peter De Bruycker
 * 
 */
public class Color implements Pattern {

    private java.awt.Color color
    
    Color(java.awt.Color color) {
        assert color != null
        
        this.color = color
    }

    /**
     * @return the color
     */
    public java.awt.Color getColor() {
        return color;
    }

    public Paint createPaint(Dimension size) {
        return color;
    }
    
}
