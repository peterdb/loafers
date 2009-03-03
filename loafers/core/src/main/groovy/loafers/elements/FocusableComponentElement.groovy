package loafers.elements

import javax.swing.JComponent

/**
 * @author Peter De Bruycker
 */
public abstract class FocusableComponentElement extends ComponentElement {

	public focus() {
		component.requestFocusInWindow()
	}
	
}
