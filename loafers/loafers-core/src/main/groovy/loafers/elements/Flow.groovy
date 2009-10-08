package loafers.elements

import loafers.elements.support.FlowLayout

/**
 * A Flow flows its elements.
 
 * @author Peter De Bruycker
 */
public class Flow extends Slot {
	public Flow() {
		super(new FlowLayout())
	}
}
