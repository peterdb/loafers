package loafers.elements

import javax.swing.event.DocumentListener
import javax.swing.JTextFieldimport javax.swing.JComponent
public class EditLine extends FocusableComponentElement {
    private Closure currentChange
    
	protected JComponent createComponent() {
        return new JTextField(25)
    }
    
    public JTextField getField() {
        return component
    }
    
    public setText(text) {
        field.text = text
    }
    
    public String getText() {
        return field.text
    }
    
    public change(Closure c) {
        if (currentChange != null) {
            field.document.removeDocumentListener(currentChange as DocumentListener)
        }
        
        if (c != null) {
            currentChange = { c(this) }
            field.document.addDocumentListener(currentChange as DocumentListener)
        }	
    }
    
    public void style(Map styles) {
        super.style(styles)
        
        if (styles.text) {
            text = styles.text
        }
        if(styles.change) {
            change(styles.change)
        }
    }
}