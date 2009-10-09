package loafers

import loafers.elements.App;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 * Entrypoint for creating Loafers applications.
 * 
 * @author Peter De Bruycker
 */
public class Loafers {

    public static App app(String title, Closure closure) {
        return app([:], title, closure)
    }
    
	public static App app(Map styles = [:], String title = "Loafers", Closure closure) {
    	assert styles != null
    	assert title != null
    	assert closure != null
    	
        App app = null
        
        // make sure everything is created on the edt
		SwingUtilities.invokeAndWait( {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

	        styles = new HashMap(styles)

        	styles.title = title

        	// create the app
            app = new App()
            app.style(styles)
            app.slot.append(closure)
            
            // TODO move this code to App and/or Window
            JFrame frame = app.frame

            if(!styles.containsKey('width') && !styles.containsKey('height')) {
                frame.pack()
            }
            
            // TODO correct place to center the frame?
            frame.setLocationRelativeTo(null)
            
            frame.visible = true
            frame.toFront()
		} as Runnable)
		
		return app
    }
}