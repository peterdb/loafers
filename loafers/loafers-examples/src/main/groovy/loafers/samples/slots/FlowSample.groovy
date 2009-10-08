package loafers.samples.slots

import loafers.Loafers


Loafers.app("Shoes") {
	stack(width:"40%") {
		background tomato
		caption "left part, 40%", width:"100%", align:"center"
		para "The left part will always be 40% of its parents width"
		para "A flow of buttons inside this stack:"
		flow {
			for (i in 1..10) {
				button "button ${i}"				
			}
		}
	}
	
	stack(width:"60%") {
		background olive
		caption "right part, 60%", align:"right", width:"100%",kerning:"10px"
		para "The right part will always be 60% of its parents width", align:"justify"
		para "A flow of paras inside this stack:"
		flow {
			background silver
			for (i in 1..10) {
				para "para ${i}-"				
			}
		}
	}
}
