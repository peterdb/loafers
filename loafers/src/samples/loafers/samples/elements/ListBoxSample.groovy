package loafers.samples.elements

import loafers.Shoes

def fruits = ['Banana', 'Apple', 'Peach']

Shoes.app("Shoes") {
	stack {
		para("Choose a fruit:")
		list_box (items:fruits) { list -> fruit.text = list.text }
		fruit = para("No fruit selected")
	}
}