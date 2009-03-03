package loafers.builder.events

import loafers.*
import javax.swing.JButton
import java.awt.event.ActionListener
import loafers.timer.*
import loafers.events.Clickimport loafers.events.Release
/**
 * @author Peter De Bruycker
 */
public class ReleaseFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        return new Release()
    } 
    
    public void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.addRelease(child)
    }
    
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        node.setClosure(childContent)
        
        return false
    }

    boolean isHandlesNodeChildren() {
        return true
    }
}
