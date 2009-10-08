package loafers.samples.simple

import loafers.Loafers

Loafers.app(width:200, height:140) {
    times = 0

    stack {
        button "Press me", {
            times ++
            sandbox.append { para "You pressed me $times times" }
        }

        sandbox = stack {}
    }
}
