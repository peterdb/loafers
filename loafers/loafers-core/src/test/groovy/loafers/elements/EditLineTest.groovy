package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JTextField
public class EditLineTest extends GroovyTestCase {
    
    public void testComponent() {
        EditLine editLine= new EditLine()
        
        assert editLine.component instanceof JTextField : "component is not a JTextField"
        assert editLine.textField instanceof JTextField : "button is not a JTextField"
        assert editLine.component == editLine.textField : "component must be the same as the field"
    }
    
    public void testText() {
        EditLine editLine = new EditLine()
        // trigger component creation
        
        editLine.text = "test"
        
        assert "test" == editLine.text
        assert "test" == editLine.styles.text
        assert "test" == editLine.textField.text    	
    }
    
    public void testChange() {
        EditLine editLine = new EditLine()
        
        String textFromFirstClosure
        String textFromSecondClosure
        
        Closure first = {
            assert it == editLine
            textFromFirstClosure = it.text
        }
        Closure second = {
            assert it == editLine
            textFromSecondClosure = it.text
        }
        
        editLine.change( first )
        
        // mimic user text entry
        editLine.textField.text = "first"
        
        assert textFromFirstClosure == "first"
        
        editLine.change( second )
        
        // mimic user text entry
        editLine.textField.text = "second"
        
        assert textFromFirstClosure == "first"
        assert textFromSecondClosure == "second"
    }
    
}