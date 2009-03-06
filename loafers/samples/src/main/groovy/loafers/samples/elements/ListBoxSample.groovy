package loafers.samples.elements

import loafers.Shoes
import groovy.lang.Category
def fruits = ['Banana', 'Apple', 'Peach']

Shoes.app("Shoes") {
	stack(margin:25) {
		para("Choose a fruit:")
		list_box (items:fruits, margin:10, width:0.5) { list -> fruit.text = list.text }
		fruit = para("No fruit selected")
	}
}