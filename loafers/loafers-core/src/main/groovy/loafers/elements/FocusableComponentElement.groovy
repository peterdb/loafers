package loafers.elements


/**
 * @author Peter De Bruycker
 */
public abstract class FocusableComponentElement extends ComponentElement {

	public focus() {
		component.requestFocusInWindow()
	}
	
}
