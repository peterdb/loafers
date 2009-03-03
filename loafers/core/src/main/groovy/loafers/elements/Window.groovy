package loafers.elements

import javax.swing.JPanel
import javax.swing.JFrameimport loafers.Stylableimport java.awt.BorderLayout
/**
 * @author Peter De Bruycker
 */
public class Window implements Stylable {
    private Window owner
    private JFrame frame
    private Slot slot
    private Map styles
    
    public Window() {
        frame = new JFrame()
    }
    
    public void append(Element e) {
        getSlot().append(e)
    }
    
    public JFrame getFrame() {
        return frame
    }
    
    public Slot getSlot() {
    	if(slot == null) {
    		slot = new Flow()
    		
            frame.add(slot.panel)
    	}
        return slot
    }
    
    public Window getOwner() {
        return owner
    }
    
    public void style(Map styles) {
    	frame.title = styles.title
    	
//    	int width = styles.width ? styles.width : 300
//    	int height = styles.height ? styles.height : 200
//    			
//    	frame.size = [width, height]
    	
    	this.styles = styles
    }
    
    public Map styles() {
    	return styles
    }
}
