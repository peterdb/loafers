package loafers.samples.slots

import loafers.Loafers


Loafers.app("Manipulation Sample") {
    button "Prepend", { 
        prepend {
            button("|<") { it.remove() } 
        }
    }
    button "Before", { 
        before p, { 
            button("<") { it.remove() } 
        }
    }
    button "After", { 
        after p, {
            button(">") { it.remove() }
        }
    }
    button "Append", { 
        append {
            button(">|") { it.remove() } 
        }
    }

    p = para("center")
}
