package loafers.elements

import javax.swing.JTextAreaimport javax.swing.event.DocumentListener
import javax.swing.JComponent
// TODO scrollpane
public class EditBox extends FocusableComponentElement {
    private Closure currentChange
    private JTextArea textArea
    
	protected JComponent createComponent() {
        textArea = new JTextArea(6, 25)
    }
    
    public JTextArea getTextArea() {
        return textArea
    }
    
    public setText(text) {
        textArea.text = text
    }
    
    public String getText() {
        return textArea.text
    }
    
    public change(Closure c) {
        if (currentChange != null) {
            textArea.document.removeDocumentListener(currentChange as DocumentListener)
        }
        
        if (c != null) {
            currentChange = { c(this) }
            textArea.document.addDocumentListener(currentChange as DocumentListener)
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