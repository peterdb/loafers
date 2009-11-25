package loafers.core

import groovy.util.GroovyTestCase;

import loafers.core.ElementBuilderMethods;
import loafers.core.LoafersClosureDelegate;
import loafers.elements.Slot
import loafers.elements.Flow
import loafers.elements.Button
import loafers.elements.TextBlock

import loafers.text.Code


public class ElementBuilderMethodsTest extends GroovyTestCase {

    private ElementBuilderMethods elementBuilderMethods
    private Slot slot
    
    @Override
    protected void setUp() throws Exception {
        slot = new Flow()

        // trigger slot component creation
        slot.component
        
        elementBuilderMethods = new ElementBuilderMethods(slot)
    }

    public void testPreconditions() {
        assert slot != null
        assert elementBuilderMethods != null

        assert elementBuilderMethods.slot == slot
    }
    
    public void testButton() {
        Button button = elementBuilderMethods.button("click me")
        
        assert button != null
        assert button.styles.text == "click me"
    }
    
    public void testButtonWithClosure(){
        Closure c = { }
        Button button = elementBuilderMethods.button("click me", c);
        
        assert button != null
        assert button.styles.text == "click me"
        assert button.styles.click == c
    }
    
    public void testButtonWithStyles(){
        Button button = elementBuilderMethods.button("click me", width:1.0, height:1.0);
        
        assert button != null
        assert button.styles.text == "click me"
        assert button.styles.width == 1.0
        assert button.styles.height == 1.0
    }
}
