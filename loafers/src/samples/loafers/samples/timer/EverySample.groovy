package loafers.samples.timer

import loafers.Shoes

Shoes.app("Every Sample") {
	stack {
		para("Every second:")
	    counter = para("count: starting")
	    every = every(1) { count -> counter.text = "count: ${count}" }
	    button("Pause") { every.toggle() }
    }
}
