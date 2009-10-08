package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JTextPane
import org.codehaus.groovy.reflection.ReflectionUtils;
import javax.swing.JLabel
/**
 * Testcase for TextBlock
 * 
 * @author Peter De Bruycker
 */
public class TextBlockTest extends ComponentElementTestCase {

    protected ComponentElement createComponentElement() {
        return new TextBlock();
    }
    
    public void testComponent() {
        TextBlock textBlock = new TextBlock()
        
        assert textBlock.component instanceof JTextPane : "component is not a JTextPane"
        assert textBlock.textPane instanceof JTextPane : "component is not a JTextPane"
        assert textBlock.component == textBlock.textPane : "component must be the same as the text pane"
        
        JTextPane pane = textBlock.textPane
        
        // we use html for text rendering
        assert pane.contentType == "text/html"

        // text pane is formatted as a label
        assert new JLabel().font == pane.font
        assert !pane.editable
        assert pane.highlighter == null
    }

    public void testReplace() {
        TextBlock textBlock = new TextBlock()

        assert "" == textBlock.text

        textBlock.replace "new text"
        assert "new text" == textBlock.text

        textBlock.replace "last text"
        assert "last text" == textBlock.text
    }

    public void testText() {
        TextBlock textBlock = new TextBlock()

        assert "" == textBlock.text

        // TODO: fix me: first we must call setText before we can use the property directly
        textBlock.setText("some text")
//        textBlock.text == "some text"
        assert "some text" == textBlock.text

        textBlock.text = null
        assert "" == textBlock.text

        textBlock.text = "last text"
        assert "last text" == textBlock.text
    }
    

}