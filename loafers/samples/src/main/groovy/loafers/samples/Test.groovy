package loafers.samples

import loafers.Shoes

Shoes.app(width:400) {
	flow {
		stack(width:200) {
			background olive
			caption "Column one"
			para "is 200 pixels wide"
		}
		stack(width:-200) {
			background blue
			background green, height:120
			background tomato, width:0.25
			caption "Column two"
			para "is 100% minus 200 pixels wide"
		}
	}
}