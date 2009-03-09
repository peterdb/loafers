package loafers.samples.elements

import loafers.Shoes

Shoes.app("Progress Sample") {
	stack() /*:margin => 0.1*/ {
		title("Progress example")
		p = progress(width:1.0)
		animate(30) { i ->
			p.fraction = i/(30)
		}
	}
}