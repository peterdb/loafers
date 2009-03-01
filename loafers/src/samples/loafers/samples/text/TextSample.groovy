package loafers.samples.text

import loafers.Shoes

Shoes.app("Text Sample") {
	stack {
		para "This is a ", strong("para"), ", the most basic text block."//, width:"100%"
		para "You can also have ", link("links") {alert("You clicked me!")}, ", which can be clicked."
	}
}
