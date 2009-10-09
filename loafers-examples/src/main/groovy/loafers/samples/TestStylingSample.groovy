package loafers.samples

import loafers.Loafers

Loafers.app {
	stack {
		// Background, text and a button: both are elements!
		def back  = background(green)
		def text  = banner("A Message for You, Rudy")
		def button = button("Stop your messin about!")
		
		// And so, they can be styled.
		text.style(size:12, stroke:tomato, margin:10)
		button.style(width:400)
		back.style(height:10)
	}
}