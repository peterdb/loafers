package loafers.builder

import javax.swing.JFrame

public class WindowFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        // TODO set current jframe as owner
        return new JFrame(title:'Shoes')
    } 
    
    public void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        if(node.size.width == 0 || node.size.height == 0) {
            node.pack()
        }
        
        node.setLocationRelativeTo(null)
        
        node.show()
    }
}