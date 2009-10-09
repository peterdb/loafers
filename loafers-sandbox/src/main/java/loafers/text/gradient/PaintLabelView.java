package loafers.text.gradient;

import java.awt.Paint;

import javax.swing.text.Element;
import javax.swing.text.LabelView;

/**
 * {@link LabelView} that uses a {@link Paint} for rendering the text.
 * 
 * @author Peter De Bruycker
 */
public class PaintLabelView extends LabelView {
    static GlyphPainter defaultPainter;
    
    public PaintLabelView(Element elem) {
        super(elem);
    }

    protected void checkPainter() {
        if (getGlyphPainter() == null) {
            if (defaultPainter == null) {
                defaultPainter = new PaintGlyphPainter(null, null);
            }
            setGlyphPainter(defaultPainter.getPainter(this, getStartOffset(), getEndOffset()));
        }
    }
}

