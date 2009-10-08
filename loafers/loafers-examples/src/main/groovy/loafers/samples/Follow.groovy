package loafers.samples

import loafers.Loafers

def FPS = 20

def trails = [[0, 0]] * FPS

Loafers.app(width:200, height:200, resizable:false) {
    getNostroke()
    fill rgb(0x3, 0x1, 0x3, 0.6)

	flow {

    	// animation at FPS frames per second
    	animate(FPS) {
    	    trails = trails[1..-1]
    	    trails << mouse[1, 2]
    
    	    clear {
    	        // TODO use gradients for better effect?
    	        
    	        // change the background based on where the pointer is
    	        background rgb(
    	                20 + (70 * (trails.last()[0].floatValue() / width)).intValue(), 
    	                20 + (70 * (trails.last()[1].floatValue() / height)).intValue(),
    	                51)
    
    	        
    	        para "${trails.last()[0]},${trails.last()[1]}", margin:5, stroke:white

//    	        trails.eachWithIndex { loc, i ->
//    	            // TODO fix inherit all settings from higher levels
//                    // TODO fix "no such property: nostroke"
//                    getNostroke()
//                    fill color(white, 0.1)
//
//                    oval left:loc[0], top:loc[1], radius:i/2, center:true
//    	        }
                fill color(white, 0.5)
                oval left:trails.last()[0], top:trails.last()[1], radius:100, center:true
    	    }
    	}
	}
}