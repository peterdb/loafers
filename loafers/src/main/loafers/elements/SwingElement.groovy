package loafers.elements

import javax.swing.JComponent
public class SwingElement extends FocusableComponentElement {
	private JComponent component
	
	public SwingElement(JComponent c) {
		assert c != null, "component cannot be null"
		
		component = c
	}
	
	protected JComponent createComponent() {
		return component
	}
}