package loafers.paint


import java.awt.Dimension;
import java.awt.Paint

import loafers.elements.PaintElement

/**
 * @author Peter De Bruycker
 */
public interface Pattern {

    Paint createPaint(Dimension size)
    
}
