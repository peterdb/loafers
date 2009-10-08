package loafers.samples.elements

import loafers.Loafers

def fruits = ['Banana', 'Apple', 'Peach']

Loafers.app("Shoes") {
	stack(margin:10) {
		caption "Choose a fruit:"
		list_box (items:fruits, margin:10, width:0.5) { list -> fruit.text = list.text }
		fruit = para("No fruit selected")
	}
}