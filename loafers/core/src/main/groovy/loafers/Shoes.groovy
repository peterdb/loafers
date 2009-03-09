package loafers

import loafers.builder.*
import com.jgoodies.looks.windows.WindowsLookAndFeelimport java.awt.Colorimport javax.swing.JFileChooserimport javax.swing.SwingUtilitiesimport java.lang.Runnableimport loafers.elements.App
import javax.swing.UIManager/**
 * @author Peter De Bruycker
 */
public class Shoes {
	public static App app(Closure closure) {
		return app([:], closure)
	}
	
    public static App app(Map styles, Closure closure) {
    	return app("Shoes", styles, closure)
    }
    
    public static App app(String title, Map styles = [:], Closure closure) {
        UIManager.setLookAndFeel(new WindowsLookAndFeel())

        App app = null
        
        // make sure everything is created on the edt
		SwingUtilities.invokeAndWait( {
	        styles = new HashMap(styles)
	        if(title != null) {
	        	styles.title = title
	        }
	        
	        ShoesBuilder builder = new ShoesBuilder()
	        
	        closure.setDelegate(builder)
	        closure.resolveStrategy = Closure.DELEGATE_FIRST
	        app = builder.app(styles) { closure() }
		} as Runnable)
		
		return app
    }
}