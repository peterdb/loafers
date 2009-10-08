package loafers.elements

import javax.swing.event.DocumentListener
import javax.swing.JTextFieldimport javax.swing.JComponent
public class EditLine extends FocusableComponentElement {
    
	protected JComponent createComponent() {
        JTextField field = new JTextField(25)
        
        field.document.addDocumentListener({
        	if(styles.change) {
        		Closure clone = styles.change.clone()
                clone.resolveStrategy = Closure.DELEGATE_FIRST

                // TODO use LoafersClosureDelegate as delegate?
                clone.delegate = parent
                clone.call(this)
        	}
        } as DocumentListener)
        
        return field
    }
    
    public JTextField getTextField() {
        return component
    }
    
    public setText(text) {
        style(['text': text])
    }
    
    public String getText() {
        return textField.text
    }
    
    public change(Closure c) {
        style([change:c])	
    }
    
    protected void doStyle(Map styles) {
        super.doStyle(styles)
        
        if (styles.text) {
        	textField.text = styles.text
        }
    }
}