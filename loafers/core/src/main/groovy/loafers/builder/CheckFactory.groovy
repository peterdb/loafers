package loafers.builder

import loafers.elements.Check
/**
 * @author Peter De Bruycker
 */
class CheckFactory extends ElementFactory  {
	public CheckFactory() {
		super(Check)
	}
	
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        node.click(childContent)
        
        return false
    }

    boolean isHandlesNodeChildren() {
        return true
    }
}
