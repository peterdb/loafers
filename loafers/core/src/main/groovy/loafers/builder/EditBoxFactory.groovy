package loafers.builder

import loafers.elements.*
import javax.swing.JTextField
import loafers.elements.EditBox
/**
 * @author Peter De Bruycker
 */
public class EditBoxFactory extends ElementFactory  {
	public EditBoxFactory() {
		super(EditBox)
	}
	
	protected void registerDefaults(Object value, Map styles) {
		if(!styles.containsKey('width')) {
			styles.width = 200
		}
		// TODO height
		
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