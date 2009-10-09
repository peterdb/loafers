package loafers.elements

import javax.swing.JButton

import loafers.core.LoafersClosureDelegate;
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

    	assert c == button.styles.click
    }
    
    public void testClick() {
        Slot slot = new Flow()
        slot.component

        Button button = new Button()

        slot.append(button)
        
        boolean click1Run = false
        boolean click2Run = false
        
        Closure click = { 
            click1Run = true
            assert it == button
            assert delegate instanceof LoafersClosureDelegate
        }
        Closure click2 = { 
            click2Run = true
            assert it == button
            assert delegate instanceof LoafersClosureDelegate
        }
        
        button.click(click)
        
        // simulate a click
        button.button.doClick()
        assert click1Run : "click closure not executed"
        
        button.click(click2)

        click1Run = false
        
        // simulate a click
        button.button.doClick()
        assert !click1Run : "first click closure not removed"
        assert click2Run : "second click closure not executed"
    }

    public void testText() {
        Button button = new Button()

        button.text = "test"

        assert "test" == button.text
        assert "test" == button.styles.text
    }
}