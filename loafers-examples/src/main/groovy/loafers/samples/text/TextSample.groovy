package loafers.samples.text

import loafers.Loafers

Loafers.app("Text Sample") {
	stack {
		caption "The following text is in a stack. A stack of paras mimics paragraphs in a book."
		stack {
			background tomato
			para "This is a ", strong("para"), ", the most basic text block."//, width:"100%"
			para "You can also have ", link("links") { alert("You clicked me!") }, ", which can be clicked."
			para del("If you make a ", strong("mistake"), ", Y"), "you can correct it."
		}
		caption "This text is in a flow, just like words in a paragraph."
		flow {
			para "This "
			para "is "
			para "like "
			para "writing "
			para "a "
			para "sentence, "
			para "but with different para elements."
		}
	}
}

