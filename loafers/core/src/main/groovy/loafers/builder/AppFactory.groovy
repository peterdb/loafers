package loafers.builder

import loafers.elements.Window
import javax.swing.JFrame
import java.util.HashMapimport loafers.elements.App
public class AppFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        App app = new App()
        
        Map styles = value instanceof Map ? new HashMap(value) : new HashMap(attributes)
        if(!styles.title) {
        	styles.title = "Shoes"
        }
        app.style(styles)
        
        return app;
     } 
     
     public void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
         JFrame frame = node.frame
     
         if(frame.size.width == 0 || frame.size.height == 0) {
             frame.pack()
         }

         frame.setLocationRelativeTo(null)
     
         frame.show()
         frame.toFront()
     }
 }