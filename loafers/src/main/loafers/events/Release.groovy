package loafers.events

import java.awt.event.MouseEvent

/**
 * @author Peter De Bruycker
 */
public class Release{
	
	private Closure closure
	
	public void setClosure(Closure c) {
		closure = c
	}
	
	public void release(MouseEvent evt) {
		switch (closure.parameterTypes.length) {
			case 0: closure(); break;
			case 1: closure(evt.getButton()); break;
			default: closure(evt.getButton(), evt.getX(), evt.getY()); break; // if one params, the closure is called with the field value
		}
	}
	
}
