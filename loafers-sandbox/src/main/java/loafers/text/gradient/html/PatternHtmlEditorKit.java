package loafers.text.gradient.html;

import javax.swing.JTextPane;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import loafers.paint.Pattern;

/**
 * @author Peter De Bruycker
 */
public class PatternHtmlEditorKit extends HTMLEditorKit {

    private static final long serialVersionUID = 1L;

    private JTextPane textPane;
    private Pattern pattern;

    public PatternHtmlEditorKit(JTextPane textPane, Pattern pattern) {
        this.textPane = textPane;
        this.pattern = pattern;
    }

    @Override
    public ViewFactory getViewFactory() {
        return new PatternViewFactory();
    }

    public class PatternViewFactory extends HTMLEditorKit.HTMLFactory {
        @Override
        public View create(Element elem) {
            Object o = elem.getAttributes().getAttribute(StyleConstants.NameAttribute);
            if (o instanceof HTML.Tag) {
                HTML.Tag kind = (HTML.Tag) o;
                if (kind == HTML.Tag.CONTENT) {
                    return new PatternInlineView(elem, textPane, pattern);
                }
            }
            
            return super.create(elem);
        }
    }

}
