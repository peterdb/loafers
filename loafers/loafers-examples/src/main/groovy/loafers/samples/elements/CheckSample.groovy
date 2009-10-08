package loafers.samples.elements

import loafers.Loafers

Loafers.app("Check Sample") {
	list = ['Frances Johnson', 'Ignatius J. Reilly', 'Winston Niles Rumfoord']
	stack {
		// TODO put this in a category?
   		map = list.inject([:]) { map, name -> 
			flow { c = check(); para(name) }
   			map[c] = name
   			return map
		}

		button("What's been checked?") {
			def selected = map.collect({ c, name -> if (c.checked) { return name } }).findAll({ it })
			alert("You selected: " + selected.join(', '))
		}
	}
}