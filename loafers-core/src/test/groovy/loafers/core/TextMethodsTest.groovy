package loafers.core

import loafers.elements.Flow;
import loafers.elements.Slot;
import loafers.elements.TextBlock;
import loafers.text.Code;
import groovy.util.GroovyTestCase;

/**
 * Testcase for TextMethods.
 * 
 * @author Peter De Bruycker
 */
public class TextMethodsTest extends GroovyTestCase {
    private TextMethods textMethods
    private Slot slot
    
    @Override
    protected void setUp() throws Exception {
        slot = new Flow()

        // trigger slot component creation
        slot.component
        
        textMethods = new TextMethods(slot)
    }

    public void testPreconditions() {
        assert slot != null
        assert textMethods != null

        assert textMethods.slot == slot
    }

    public void testPara() {
        TextBlock para = textMethods.para("this is the text")

        assert para != null
        assert para.text == "this is the text"

        assert para.parent == slot
    }
    
    public void testCode() {
        Code code = textMethods.code("test")
        assert "<code>test</code>" == code.getHtmlFragment()

        Code code2 = textMethods.code("item1", " ", "item2")
        assert "<code>item1&nbsp;item2</code>" == code2.getHtmlFragment()
        
        Code code3 = textMethods.code("code", textMethods.em("em"))
        assert "<code>code<em>em</em></code>" == code3.getHtmlFragment()
    }
}
