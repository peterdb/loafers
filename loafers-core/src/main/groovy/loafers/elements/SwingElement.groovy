package loafers.elements


/**
 * Allows embedding of arbitrary Swing components.
 * 
 * @author Peter De Bruycker
 */
	private JComponent component
	
	public SwingElement(JComponent c) {
		assert c != null, "component cannot be null"
		
		component = c
	}
	
	protected JComponent createComponent() {
		return component
	}
}