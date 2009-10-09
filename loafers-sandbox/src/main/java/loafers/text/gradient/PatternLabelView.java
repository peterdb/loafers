package loafers.text.gradient;

import javax.swing.text.Element;
import javax.swing.text.LabelView;

/**
 * {@link LabelView} that uses {@link PatternGlyphPainter} for rendering the text.
 * 
 * @author Peter De Bruycker
 */
public class PatternLabelView extends LabelView {
    static GlyphPainter defaultPainter;
    
    public PatternLabelView(Element elem) {
        super(elem);
    }

    protected void checkPainter() {
        if (getGlyphPainter() == null) {
            if (defaultPainter == null) {
                defaultPainter = new PatternGlyphPainter(null, null);
            }
            setGlyphPainter(defaultPainter.getPainter(this, getStartOffset(), getEndOffset()));
        }
    }
}

