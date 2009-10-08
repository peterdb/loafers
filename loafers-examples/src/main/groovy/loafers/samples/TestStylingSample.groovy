package loafers.samples

import loafers.Loafers

Loafers.app {
	stack {
		// Background, text and a button: both are elements!
		back  = background(green)
		text  = banner("A Message for You, Rudy")
		press = button("Stop your messin about!")
		
		// And so, they can be styled.
		text.style(size:12, stroke:tomato, margin:10)
		press.style(width:400)
		back.style(height:10)
	}
}