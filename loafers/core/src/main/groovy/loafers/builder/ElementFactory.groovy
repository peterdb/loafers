package loafers.builder;

import loafers.elements.Elementimport loafers.elements.Slotimport loafers.elements.Windowimport loafers.elements.ComponentElement
public abstract class ElementFactory extends AbstractFactory {
	private Class elementClass
	
	public ElementFactory(Class<? extends Element> elementClass) {
		assert elementClass != null, "elementClass cannot be null"
		
		this.elementClass = elementClass
	}
	
	public final Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        Element element = elementClass.newInstance()
        
        // trigger component creation, so that the styling can happen
        if(element instanceof ComponentElement) {
        	element.getComponent()
        }
        
        Map styles = new HashMap(attributes)
        registerDefaults(value, styles)
    	element.style(styles)
        
        return element;
    } 
	
	protected void registerDefaults(Object value, Map styles) {
		
	}
	
    public final boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
    	// all node attributes are captured in the styles map, so we process them ourselves
    	return false
    }
	
    public final void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
    	assert parent instanceof Slot || parent instanceof Window
    	
        parent.append(child)
    }
}
