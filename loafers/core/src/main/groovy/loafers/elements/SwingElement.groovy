package loafers.elements

import javax.swing.JComponent

	private JComponent component
	
	public SwingElement(JComponent c) {
		assert c != null, "component cannot be null"
		
		component = c
	}
	
	protected JComponent createComponent() {
		return component
	}
}