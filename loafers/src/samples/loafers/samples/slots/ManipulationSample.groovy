package loafers.samples.slots

import loafers.Shoes


Shoes.app("Manipulation Sample") {
	stack {
		sandbox = flow { p = para("The sandbox") }
		flow {
			button "Prepend", { sandbox.prepend( button("Prepended") { it.remove() } ) }
			button "Before", { sandbox.before( p, button("Before") { it.remove() } ) }
			button "After", { sandbox.after( p, button("After") { it.remove() } ) }
			button "Append", { sandbox.append( button("Appended") { it.remove() } ) }
		}
	}
}
