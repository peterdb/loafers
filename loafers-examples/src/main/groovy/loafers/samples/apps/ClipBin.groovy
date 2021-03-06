package loafers.samples.apps

import loafers.Loafers

Loafers.app("ClipBin") {
	lastClipText = ""
	clipNum = 1
	
	bin = stack(width:"100%") {}
	
	// repeat every second
	every(1) {
		clipText = clipboard()
		if (clipText != lastClipText) {
			// add new entries to the top of the bin
			bin.prepend(stack() {
				background(tomato)
				// border(white, :strokewidth => 3)
				caption strong(clipNum), ". ", String.format("%tY/%<tm/%<td %<tH:%<tM:%<tS", new Date())
				para(clipText, margin:10)
				edit_box clipText, width:1.0, height:50
			})
			lastClipText = clipText
			clipNum = clipNum + 1
		}
	}
}

