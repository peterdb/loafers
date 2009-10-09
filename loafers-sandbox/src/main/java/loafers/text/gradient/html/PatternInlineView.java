package loafers.text.gradient.html;

import javax.swing.text.Element;
import javax.swing.text.html.InlineView;

import loafers.text.gradient.PatternGlyphPainter;

/**
 * @author Peter De Bruycker
 *
 */
public class PatternInlineView extends InlineView {

    static GlyphPainter defaultPainter;

    public PatternInlineView(Element elem) {
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
