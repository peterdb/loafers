package loafers.builder

import loafers.elements.ListBox
/**
 * @author Peter De Bruycker
 */
public class ListBoxFactory extends ElementFactory  {
	public ListBoxFactory() {
		super(ListBox)
	}

	protected void registerDefaults(Object value, Map styles) {
		assert value == null || value instanceof List
		
		if(value != null) {
			styles.items = value
		}
		
		if(!styles.width) {
			styles.width = 200
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