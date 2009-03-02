package loafers.samples.elements

import loafers.Shoes

def fruits = ['Banana', 'Apple', 'Peach']

Shoes.app("Shoes") {
	stack(margin:10) {
		para("Choose a fruit:")
		list_box (items:fruits, margin:10) { list -> fruit.text = list.text }
		fruit = para("No fruit selected")
	}
}