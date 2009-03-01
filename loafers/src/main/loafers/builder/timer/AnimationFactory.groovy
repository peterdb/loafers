package loafers.builder.timer

import loafers.*
import javax.swing.JButton
import java.awt.event.ActionListener
import loafers.timer.*

/**
 * @author Peter De Bruycker
 */
class AnimationFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        int fps = value == null ? 10 : value
        
        return new Animation(fps)
    } 
    
    public void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        node.start()
    }
    
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        node.setTrigger(childContent)
        
        return false
    }

    boolean isHandlesNodeChildren() {
        return true
    }
}
