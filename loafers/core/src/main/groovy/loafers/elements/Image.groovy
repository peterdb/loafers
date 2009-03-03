package loafers.elements

import javax.swing.JLabelimport javax.swing.ImageIconimport java.net.URLimport javax.swing.JComponent
public class Image extends ComponentElement {
	protected JComponent createComponent() {
		return new JLabel()
	}
	
	public JLabel getLabel() {
		return component
	}
	
	public void style(Map styles) {
		super.style(styles)
		
		if(styles.path) {
			URL url = null
			
			try {
				url = new URL(path)
			} catch (Exception e) {
				url = getClass().getResource(path)
			}
			
			if(url == null) {
				throw new IllegalArgumentException(path+" cannot be found")
			}
			
			label.icon = new ImageIcon(url)
		}
	}
	
	public void setPath(String path) {
		style(['path':path])
	}
}