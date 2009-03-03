package loafers.builder

import loafers.elements.*
import javax.swing.JComponentimport loafers.elements.SwingElement
/**
 * @author Peter De Bruycker
 */
class SwingFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
    	assert value != null, "Value cannot be null"
        assert value instanceof JComponent, "Value must be a component"
        
        return new SwingElement(value);
    } 
}
