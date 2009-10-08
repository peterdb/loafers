package loafers.builder

import groovy.util.GroovyTestCase;

import loafers.LoafersClosureDelegate;
import loafers.elements.Slot
import loafers.elements.Flow
import loafers.elements.Button
import loafers.elements.TextBlock

import loafers.text.Code


public class ElementsBuilderTest extends GroovyTestCase {

    private ElementsBuilder builder
    private Slot slot
    
    @Override
    protected void setUp() throws Exception {
        slot = new Flow()

        // trigger slot component creation
        slot.component
        
        builder = new ElementsBuilder()
        builder.slot = slot
    }

    public void testPreconditions() {
        assert slot != null
        assert builder != null

        assert builder.slot == slot
    }
    
    public void testCode() {
        Code code = builder.code("test")
        assert "<code>test</code>" == code.getHtmlFragment()

        Code code2 = builder.code("item1", " ", "item2")
        assert "<code>item1&nbsp;item2</code>" == code2.getHtmlFragment()
        
        Code code3 = builder.code("code", builder.em("em"))
        assert "<code>code<em>em</em></code>" == code3.getHtmlFragment()
    }
    
    public void testButton() {
        Button button = builder.button("click me")
        
        assert button != null
        assert button.styles.text == "click me"
    }
    
    public void testButtonWithClosure(){
        Closure c = { }
        Button button = builder.button("click me", c);
        assert button != null
        assert button.styles.text == "click me"
        assert button.styles.click == c
    }
    
    public void testButtonWithStyles(){
        Button button = builder.button("click me", width:1.0, height:1.0);
        assert button != null
        assert button.styles.text == "click me"
        assert button.styles.width == 1.0
        assert button.styles.height == 1.0
    }

    public void testPara() {
        TextBlock para = builder.para("this is the text")

        assert para != null
        assert para.text == "this is the text"
    }
}
