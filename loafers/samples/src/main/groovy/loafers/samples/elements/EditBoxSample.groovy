package loafers.samples.elements

import loafers.Shoes

Shoes.app("Edit Box Sample") {
	stack {
		edit_box(width:"100%") { e -> counter.text = e.text.length() }
		counter = strong("0")
		para counter, " characters"
   }
}