package loafers.builder

import loafers.elements.Button
/**
 * @author Peter De Bruycker
 */
class ButtonFactory extends ElementFactory  {
	public ButtonFactory() {
		super(Button)
	}
	
	protected void registerDefaults(Object value, Map styles) {
    	if (value != null) {
    		styles.text = value
    	}
	}
	
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        node.click(childContent)
        
        return false
    }

    boolean isHandlesNodeChildren() {
        return true
    }
}
