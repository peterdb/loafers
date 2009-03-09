package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JTextPaneimport javax.swing.JLabel
public class TextBlockTest extends GroovyTestCase {
    
    public void testComponent() {
        TextBlock textBlock = new TextBlock()
        
        assert textBlock.component instanceof JTextPane : "component is not a JTextPane"
        assert textBlock.textPane instanceof JTextPane : "button is not a JTextPane"
        assert textBlock.component == textBlock.textPane : "component must be the same as the text pane"
        
        JTextPane pane = textBlock.textPane
        
        // we use html for text rendering
        assert pane.contentType == "text/html"
        
        assert new JLabel().font == pane.font
        assert !pane.editable
        assert pane.highlighter == null
    }
    

}