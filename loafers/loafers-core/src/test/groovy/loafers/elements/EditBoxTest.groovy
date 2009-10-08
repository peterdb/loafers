package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JTextAreaimport javax.swing.JScrollPane
public class EditBoxTest extends GroovyTestCase {
    
    public void testComponent() {
        EditBox editBox= new EditBox()
        
        assert editBox.component instanceof JScrollPane: "component is not a JScrollPane"
        JScrollPane scrollPane = editBox.component
        assert scrollPane.viewport.view instanceof JTextArea, "scroll pane must contain a JTextArea"
        assert editBox.textArea instanceof JTextArea: "textArea property is not a JTextArea"
        assert scrollPane.viewport.view == editBox.textArea
    }
    
    public void testStyle() {
    	EditBox editBox = new EditBox()
    	// trigger component creation
    	editBox.getComponent()
    	
    	editBox.text = "test"
    	
    	assert "test" == editBox.text
    	assert "test" == editBox.styles.text
    	assert "test" == editBox.textArea.text
    }
    
    public void testChange() {
        EditBox editBox = new EditBox()
        // trigger component creation
        editBox.getComponent()
        
        String textFromFirstClosure
        String textFromSecondClosure
        
        Closure first = {
            assert it == editBox
            textFromFirstClosure = it.text
        }
        Closure second = {
            assert it == editBox
            textFromSecondClosure = it.text
        }
        
        editBox.change( first )
        
        editBox.textArea.text = "first"
        
        assert textFromFirstClosure == "first"
        
        editBox.change( second )
        
        editBox.textArea.text = "second"
        
        assert textFromFirstClosure == "first"
        assert textFromSecondClosure == "second"
    }
    
}