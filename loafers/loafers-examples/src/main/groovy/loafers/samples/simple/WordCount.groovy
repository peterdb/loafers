package loafers.samples.simple

import loafers.Loafers

// counts the words from a string in the clipboard
// based on http://the-shoebox.org/apps/82


Loafers.app("word count", width:660, height:99) {
    int fps = 60
    int wordcount = clipboard?.split(' ').size()
    float countup = 0.0

    background gradient(rgb(100,100,100),rgb(0,0,0))

    stack {
        worddisplay = para("", font:'Verdana', size:48, stroke:"#EEE")
    }

    animate(fps) {
        if(countup < wordcount) {
            countup = countup + (wordcount / fps * 5.0)
 
            worddisplay.text = " word count = ${countup.toInteger()}"
        }
    }

    keypress {
        println "jup"
        exit()
    }
}
