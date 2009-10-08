package loafers.samples

import loafers.Loafers

Loafers.app {
	stack {
		background white
		title "Loafers Samples", width:1.0, align:"center"
		caption "These are the samples in this release."
		subtitle "Elements"
		stack {
			background bisque
			para "- ", link("Button", { println it }), ": Simple buttons."
		}
	}
}