package loafers.samples.art;

import loafers.Loafers

Loafers.app {
    stack {
        para "Oval", margin:10
        flow margin:10, height:50, {
            stroke red
            fill blue
            oval left:10, top:0, radius:40
    
            getNostroke()
            fill blue
            oval left:60, top:0, width:60, height:40
    
            stroke red
            getNofill()
            oval left:130, top:0, width:20, height:40
        }
        para "Rect", margin:10
        flow margin:10, height:50, {
            stroke red
            fill blue
            rect left:10, top:0, width:40, height:40
    
            getNostroke()
            fill blue
            rect left:60, top:0, width:60, height:40
    
            stroke red
            getNofill()
            rect left:130, top:0, width:20, height:40
        }
        flow margin:10, height:50, {
            stroke red
            fill blue
            rect left:10, top:0, width:40, height:40, curve:10
    
            getNostroke()
            fill blue
            rect left:60, top:0, width:60, height:40, curve:15
    
            stroke red
            getNofill()
            rect left:130, top:0, width:20, height:40, curve:5
        }
    }
}