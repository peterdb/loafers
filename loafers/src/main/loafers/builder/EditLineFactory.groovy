package loafers.builder

import loafers.elements.*
import javax.swing.JTextField
import loafers.elements.EditLine
/**
 * @author Peter De Bruycker
 */
public class EditLineFactory extends ElementFactory  {
	public EditLineFactory() {
		super(EditLine)
	}

	protected void registerDefaults(Object value, Map styles) {
		if(!styles.containsKey('width')) {
			styles.width = 200
		}
		
    	if (value != null) {
    		styles.text = value.toString()
    	}
	}
	
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        node.change(childContent);
        
        return false
    }
    
    boolean isHandlesNodeChildren() {
        return true
    }
}