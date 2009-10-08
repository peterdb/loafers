package loafers.elements

import loafers.elements.support.StackLayout

/**
 * A Stack stacks its elements.
 *
 * @author Peter De Bruycker
 */
public class Stack extends Slot {
	public Stack() {
		super(new StackLayout())
	}
}
