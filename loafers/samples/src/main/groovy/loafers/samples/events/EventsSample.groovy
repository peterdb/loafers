package loafers.samples.events

import loafers.Shoes

Shoes.app("Events Sample"){
   stack {
     label = para("just starting")
     click { button, x, y -> 
    	 label.text = "clicked"    	 
     }
     release { 
    	 label.text = "released"    	 
     }
//     hover {
//     	label.text = "hover"
//     }
//     leave {
//     	label.text = " "
//     }
   }
}

