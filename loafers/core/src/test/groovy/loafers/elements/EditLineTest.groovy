package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JTextField
public class EditLineTest extends GroovyTestCase {
    
    public void testComponent() {
        EditLine editLine= new EditLine()
        
        assert editLine.component instanceof JTextField : "component is not a JTextField"
        assert editLine.field instanceof JTextField : "button is not a JTextField"
        assert editLine.component == editLine.field : "component must be the same as the field"
    }
    
    public void testSize() {
        EditLine editLine = new EditLine()
        
        String textFromFirstClosure
        String textFromSecondClosure
        
        Closure first = { textFromFirstClosure = it.text }
        Closure second = { textFromSecondClosure = it.text }
        
        editLine.change( first )
        
        editLine.field.text = "first"
        
        assert textFromFirstClosure == "first"
        
        editLine.change( second )
        
        editLine.field.text = "second"
        
        assert textFromFirstClosure == "first"
        assert textFromSecondClosure == "second"
    }
    
}