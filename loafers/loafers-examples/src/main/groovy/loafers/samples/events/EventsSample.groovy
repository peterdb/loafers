package loafers.samples.events

import loafers.Loafers
import loafers.elements.EditBox

Loafers.app("Events Sample"){
    def EditBox output

    def log = { message ->
        output.text = "$output.text\n$message"
    }
    
    stack {
        click { button, x, y -> 
            log("clicked at $x,$y")
 	    }
        press { 
            log("pressed")
        }
        release { 
            log("released")
        }
//     hover {
//     	label.text = "hover"
//     }
//     leave {
//     	label.text = " "
//     }

        output = edit_box
        output.style(['width':1.0])

        println "#aaa"..tomato
    }
}

