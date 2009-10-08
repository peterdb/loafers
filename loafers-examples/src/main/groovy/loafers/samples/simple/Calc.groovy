package loafers.samples.simple

import loafers.Loafers

class State {
    private number = 0
    private previous
    private String op

    public String toString() {
        return number.toString()
    }

    public void press(int digit) {
        assert 0 <= digit && digit <= 9

        number = number * 10 + digit
    }

    public void clear() {
        number = 0
    }

    public void op(String op) {
        if(this.op) {
            equals()
        }
        this.op = op
        previous = number
        number = 0
    }

    public void equals() {
        if(this.op) {
            number = previous."$op"(number)
        }
        op = null
    }
}

def display
def state = new State()

Loafers.app height:250, width:200, resizable:false, {
    //background "#EEC".."#996", :curve => 5, :margin => 2
 
    stack margin:2, {
 
        stack margin:8, {
            display = para(strong(state))
        }
 
        flow width:218, margin:4, {
            [7, 8, 9, "/", 4, 5, 6, "*", 1, 2, 3, "-", 0, "Clr", "=", "+"].each { btn ->
                button btn, width:46, height:46, {
                    switch (btn) {
                        case 0..9: state.press(btn); break
                        case "/": state.op("div"); break
                        case "*": state.op("multiply"); break
                        case "+": state.op("plus"); break
                        case "-": state.op("minus"); break
                        case "Clr": state.clear(); break
                        case "=": state.equals(); break
                    }

                    display.text = strong(state)
                }
            }
        }
    }
}

