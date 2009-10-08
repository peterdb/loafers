package loafers.samples.simple

import loafers.Loafers

Loafers.app width:300, height:150, margin:10, {
    def display = {
        answer.text = it 
    }

    button "Alert", {
        alert "Alert alert!"
    }
    
    button "Ask", {
        display ask("What is your name?")
    }

    button "Confirm", {
        display confirm("Would you like to proceed?")
    }

    button "Open File...", {
        display ask_open_file()
    }

    button "Save File...", {
        display ask_save_file()
    }

    button "Open Folder...", {
        display ask_open_folder()
    }

    button "Save Folder...", {
        display ask_save_folder()
    }

    button "Color", {
        display ask_color("Pick a color")
    }

    answer = para("Answers appear here")
}