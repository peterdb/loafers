package loafers.elements

import javax.swing.JTextAreaimport javax.swing.event.DocumentListener
import javax.swing.JComponentimport javax.swing.JScrollPane
/**
 * An EditBox element provides a multi-line edit field inside a scrollpane.
 * 
 * @author Peter De Bruycker
 */
public class EditBox extends FocusableComponentElement {
    // TODO provide methods for appending/prepending text?
    
    private JTextArea textArea
    
	protected JComponent createComponent() {
        textArea = new JTextArea(6, 25)
        
        textArea.document.addDocumentListener({
        	if(styles.change){
        		Closure clone = styles.change.clone()
                clone.resolveStrategy = Closure.DELEGATE_FIRST

                // TODO use LoafersClosureDelegate as delegate?
                clone.delegate = parent
                clone.call(this)
        	}
        } as DocumentListener)
        
        return new JScrollPane(textArea)
    }
    
    public JTextArea getTextArea() {
        return textArea
    }
    
    public setText(text) {
        style(['text':text])
    }
    
    public String getText() {
        return textArea.text
    }
    
    public change(Closure c) {
        style([change:c])
    }
    
    protected void doStyle(Map styles) {
        super.doStyle(styles)
        
        if (styles.text) {
            textArea.text = styles.text
        }
    }
}