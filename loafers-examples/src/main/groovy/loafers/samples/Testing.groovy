package loafers.samples

Loafers.app {
	s = stack {
		para "jup"
	}
	button "click me", { s.append { para "woohoo" } }
}