package loafers.elements

import javax.swing.JButton
import groovy.util.GroovyTestCase
public class ButtonTest extends GroovyTestCase {
    
    public void testComponent() {
        Button button = new Button()
        
        assert button.component instanceof JButton : "component is not a JButton"
        assert button.button instanceof JButton : "button is not a JButton"
        assert button.component == button.button : "component must be the same as the button"
    }
    
    public void testClickStyle() {
    	Button button = new Button()
    	
    	assert !button.styles.click
    	
    	Closure c = { /* empty */ }
    	
    	button.click(c)
    	
    }
    
    public void testClick() {
    	Button button = new Button()
        
        def testValue = "not clicked"
        def testValue2 = "not clicked"
        
        Closure click = { testValue = "clicked" }
        Closure click2 = { testValue2 = "clicked" }
        
        button.click(click)
        
        // simulate a click
        button.button.doClick()
        assert testValue == "clicked" : "click closure not executed"
        
        testValue = "not clicked"
        
        button.click(click2)
        
        // simulate a click
        button.button.doClick()
        assert testValue == "not clicked" : "first click closure not removed"
        assert testValue2 == "clicked" : "second click closure not executed"
        
        // verify that button is passed to it's click closure
        def value = null
        
        Closure anotherClick = { btn -> value = btn }
        button.click(anotherClick)
        
        button.button.doClick()
        assert value == button : "button is not passed to it's click closure"
    }
}