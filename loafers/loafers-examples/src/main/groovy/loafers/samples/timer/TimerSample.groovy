package loafers.samples.timer

import loafers.Loafers

Loafers.app("Timer Sample") {
	stack {
	    p = para(" ")
		timer(5) { p.text = "5 seconds have passed" }
    }
}
