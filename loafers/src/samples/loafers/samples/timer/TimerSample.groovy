package loafers.samples.timer

import loafers.Shoes

Shoes.app("Timer Sample") {
	stack {
	    p = para(" ")
		timer(5) { p.text = "5 seconds have passed" }
    }
}
