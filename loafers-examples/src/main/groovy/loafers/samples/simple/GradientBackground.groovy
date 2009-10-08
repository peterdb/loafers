package loafers.samples.simple

import java.awt.Color
import loafers.Loafers

Loafers.app(width:300, height:150) {
    stack {
        background gradient(papayawhip, peru)

        stack(margin:5) {
            background gradient(olive, tomato)
            border gradient(crimson, indigo), strokewidth:5

            // TODO textblock in a stack must have width 1.0 by default? 
            title "Title", width:1.0, align:"center", margin:10
        }

        stack(margin:5) {
            para "This is a paragraph, it should span multiple lines."
        }
    }
}
