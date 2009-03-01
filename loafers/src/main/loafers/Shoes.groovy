package loafers

import loafers.builder.*
import com.jgoodies.looks.windows.WindowsLookAndFeelimport java.awt.Colorimport javax.swing.JFileChooserimport org.jvnet.substance.skin.SubstanceBusinessLookAndFeelimport javax.swing.SwingUtilitiesimport java.lang.Runnableimport loafers.elements.App
import javax.swing.UIManager/**
 * @author Peter De Bruycker
 */
public class Shoes {
    static black = Color.black;
    static white = Color.white;
    static red = Color.red;
    static green = Color.green;
    static blue = Color.blue;
	
    public static App app(String title = "Shoes", Map styles = [:], Closure closure) {
        UIManager.setLookAndFeel(new WindowsLookAndFeel())

        App app = null
        
        // make sure everything is created on the edt
		SwingUtilities.invokeAndWait( {
	        styles = new HashMap(styles)
	        if(title != null) {
	        	styles.title = title
	        }
	        
	        ShoesBuilder shoes = new ShoesBuilder()
	        
	        closure.setDelegate(shoes)
	        closure.resolveStrategy = Closure.DELEGATE_FIRST
	        app = shoes.app(styles) { closure() }
		} as Runnable)
		
		return app
    }
    

}