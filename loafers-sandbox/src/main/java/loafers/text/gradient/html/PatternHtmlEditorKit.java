package loafers.text.gradient.html;

import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.InlineView;

/**
 * @author Peter De Bruycker
 * 
 */
public class PatternHtmlEditorKit extends HTMLEditorKit {

    @Override
    public ViewFactory getViewFactory() {
        return new PatternViewFactory();
    }

    public static class PatternViewFactory extends HTMLEditorKit.HTMLFactory {
        @Override
        public View create(Element elem) {
            Object o = elem.getAttributes().getAttribute(StyleConstants.NameAttribute);
            if (o instanceof HTML.Tag) {
                HTML.Tag kind = (HTML.Tag) o;
                if (kind == HTML.Tag.CONTENT) {
                    return new PatternInlineView(elem);
                }
            }
            
            return super.create(elem);
        }
    }

}
