package loafers.samples.elements

import loafers.Loafers

Loafers.app("Button Sample") {
    stack {
        button "ttt"
        button "ttt", { alert "clicked me!" }
        button "ttt", width:0.5, { alert "clicked me!" }
        button "ttt", width:1.0, { alert "clicked me!" }
    }
}