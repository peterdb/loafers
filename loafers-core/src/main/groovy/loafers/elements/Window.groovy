package loafers.elements

import javax.swing.JPanel
import javax.swing.JFrameimport java.awt.BorderLayoutimport java.awt.Colorimport java.awt.MouseInfoimport groovy.lang.Delegateimport loafers.builder.ElementsBuilder

/**
 * @author Peter De Bruycker
 */
public class Window implements Stylable {
    private Window owner
    private JFrame frame

    // TODO make slot a Delegate -> a Window is also a Flow
    private Flow slot = new Flow()
    
    private Map styles = [:]
    private JPanel rootPanel
    
    public Window() {
        frame = new JFrame()
        rootPanel = new JPanel(new BorderLayout())
        rootPanel.background = Color.WHITE
        rootPanel.opaque = true
        rootPanel.add(slot.component)

        frame.add(rootPanel)
    }
    
    public JFrame getFrame() {
        return frame
    }
    
    public Window getOwner() {
        return owner
    }
    
    public String getTitle() {
    	return styles.title
    }
    
    public void setTitle(String title) {
    	style(['title':title])
    }
    
    public void style(Map styles) {
    	frame.title = styles.title

    	if(styles.width && styles.height) {
    		frame.size = [(int)styles.width, (int)styles.height]
    	} else if (styles.width) {
    		frame.pack()
    		frame.size = [(int)styles.width, (int)frame.size.height]
    	} else if (styles.height) {
    		frame.pack()
    		frame.size = [(int)frame.size.width, (int)styles.height]
    	} else {
    	    frame.pack()
    	}
    	
    	if(styles.containsKey("resizable")) {
    		if(styles["resizable"] == false) {
    			frame.resizable = false
    		} else {
    			frame.resizable = true
    		}
    	}
    	
    	this.styles.putAll(styles)
    }
    
    public Map getStyles() {
    	return styles
    }

    private lastMouse = [0, 0, 0]
    
    public List getMouse() {
    	def pos = frame.mousePosition

    	if(pos != null) {
            lastMouse = [0, (int)pos.x, (int)pos.y]
    	}

    	return lastMouse
    }
    
    public Slot getSlot() {
    	return slot
    }

    public void close() {
        frame.dispose()
        frame.setVisible(false)
    }
}
