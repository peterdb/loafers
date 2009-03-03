package loafers.samples.timer

import loafers.Shoes

Shoes.app("Animation Sample") {
	stack {
		para("Animation 24fps")
	    counter = para("frame: starting")
	    animation = animate(24) { frame -> counter.text = "frame: ${frame}" }
	    button("Pause") { animation.toggle() }
    }
}
