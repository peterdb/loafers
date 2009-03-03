package loafers.samples.elements

import loafers.Shoes

Shoes.app("Edit Line Sample") {
	stack {
		edit_line { e -> counter.text = e.text.length() }
		counter = strong("0")
		para counter, " characters"
   }
}