package loafers.builder

import loafers.elements.Window
import javax.swing.JFrame
import java.util.HashMapimport loafers.elements.App
public class AppFactory extends AbstractFactory  {
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
    	def title = null
    	if (value instanceof Map) {
    		title = value.title
    	} else {
    		title = value
    	}
    	
    	if (title == null) {
    		title = "Shoes"
    	}
    
        App app = new App()
        
        Map styles = new HashMap(attributes)
        styles.title = title
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