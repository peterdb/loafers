package loafers.text.gradient.html;

import javax.swing.JTextPane;
import javax.swing.text.Element;
import javax.swing.text.html.InlineView;

import loafers.paint.Pattern;

/**
 * @author Peter De Bruycker
 */
public class PatternInlineView extends InlineView {

    private static GlyphPainter defaultPainter;
    
    private JTextPane textPane;
    private Pattern pattern;

    public PatternInlineView(Element elem, JTextPane textPane, Pattern pattern) {
        super(elem);
        this.textPane = textPane;
        this.pattern = pattern;
    }

    protected void checkPainter() {
        if (getGlyphPainter() == null) {
            if (defaultPainter == null) {
                defaultPainter = new PatternGlyphPainter(null, null, textPane, pattern);
            }
            setGlyphPainter(defaultPainter.getPainter(this, getStartOffset(), getEndOffset()));
        }
    }

}
