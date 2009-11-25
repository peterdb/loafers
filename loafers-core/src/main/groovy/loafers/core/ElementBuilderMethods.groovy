package loafers.core

import java.util.Map;

import javax.swing.JComponent

import loafers.core.support.SlotMethodsSupport;
import loafers.events.Release;
import loafers.elements.Element;
import loafers.events.Click;
import loafers.events.Motion;
import loafers.elements.Background;
import loafers.elements.Border;
import loafers.elements.Button;
import loafers.elements.Flow;
import loafers.elements.Stack;
import loafers.elements.Slot;
import loafers.elements.SwingElement;
import loafers.elements.Image;
import loafers.elements.ListBox;
import loafers.elements.Check;
import loafers.elements.EditLine;
import loafers.elements.EditBox;

import loafers.paint.Pattern;
import loafers.paint.Color;

public class ElementBuilderMethods extends SlotMethodsSupport {

    public ElementBuilderMethods(Slot slot, Closure addStrategy = null) {
        super(slot, addStrategy)
    }
    
    public Stack stack(Closure content = null) {
        return stack([:], content);
    }
    
    public Stack stack(Map styles, Closure content = null) {
        Stack stack = new Stack()

        stack.style(styles)

        if(content != null) {
            stack.append(content)
        }

        addElement(stack)
        
        return stack
    }

    public Flow flow(Closure content = null) {
        return flow([:], content);
    }
    
    public Flow flow(Map styles, Closure content = null) {
        Flow flow = new Flow()
        
        flow.style(styles)

        if(content != null) {
            flow.append(content)
        }
        
        addElement(flow)
        
        return flow
    }

    public Background background(String color) {
        return background([:], color)
    }

    public Background background(Map styles, String color) {
        return background(styles, fromString(color))
    }

    public Background background(Color color) {
        return background([:], color)
    }

    public Background background(java.awt.Color color) {
        return background([:], color)
    }

    public Background background(Map styles, java.awt.Color color) {
        assert styles != null
        assert color != null
        
        return background(styles, new Color(color))
    }

    public Background background(Pattern pattern = null) {
        return background([:], pattern)
    }

    public Background background(Map styles, Pattern pattern = null) {
        assert styles != null
        
        Background background = new Background()

        if(pattern != null) {
            styles['pattern'] = pattern
        }
        background.style(styles)
        
        addElement(background)
        
        return background
    }

    public Border border(String color) {
        return border([:], color)
    }

    public Border border(Map styles, String color) {
        return border(styles, fromString(color))
    }

    public Border border(Color color) {
        return border([:], color)
    }

    public Border border(Map styles, java.awt.Color color) {
        assert styles != null
        assert color != null
        
        return border(styles, new Color(color))
    }

    public Border border(Pattern pattern = null) {
        return border([:], pattern)
    }

    public Border border(Map styles, Pattern pattern = null) {
        assert styles != null
        
        Border border = new Border()

        if(pattern != null) {
            styles['pattern'] = pattern
        }
        border.style(styles)
        
        addElement(border)
        
        return border
    }

    public Button button(Object text) {
        return button([:], text, null)
    }
    
    public Button button(String text, Closure click) {
        return button([:], text, click);
    }
    
    public Button button(Map styles, Object text, Closure click = null) {
        assert text != null, "text cannot be null"
        assert styles != null, "styles cannot be null"
        
        Button button = new Button()
        
        styles.text = text.toString()
        if(click) {
            styles.click = click
        }
        button.style(styles)
        
        addElement(button)
        
        return button
    }
    
    public Check check(Map styles = [:]) {
//        assert styles != null, "styles cannot be null"

        Check check = new Check()

        if(styles == null) {
            styles = [:]
        }
        check.style(styles)
        
        addElement(check)
        
        return check
    }

    public ListBox list_box(Closure change = null) {
        return list_box([:], change)
    }

    public ListBox list_box(Map styles, Closure change = null) {
        ListBox listBox = new ListBox()

        if(change) {
            styles.change = change
        }
        listBox.style(styles)
        
        addElement(listBox)

        return listBox
    }

    // TODO add edit_line and edit_box methods that accept a string (=initial text)
    
    public EditLine edit_line(Closure change = null) {
        return edit_line([:], change)
    }

    public EditLine edit_line(Map styles, Closure change = null) {
        EditLine editLine = new EditLine()

        if(change) {
            styles.change = change
        }
        editLine.style(styles)
        
        addElement(editLine)

        return editLine
    }

    public EditBox getEdit_box() {
        return edit_box([:])
    }
    
    public EditBox edit_box(Closure change) {
        return edit_box([:], change)
    }

    public EditBox edit_box(Map styles, Closure change = null) {
        EditBox editBox = new EditBox()

        if(change) {
            styles.change = change
        }
        editBox.style(styles)
        
        addElement(editBox)

        return editBox
    }

    public Image image(String path = null) {
        return image([:], path)
    }

    public Image image(Map styles, String path = null) {
        Image image = new Image()

        if(path) {
            styles.path = path
        }
        image.style(styles)
        
        addElement(image)
        
        return image
    }

    public SwingElement swing(Map styles = [:], JComponent component) {
        SwingElement swing = new SwingElement()

        addElement(swing)
        
        return swing
    }

    // TODO these methods are obsolete, as we delegate to the slot in the LoafersClosureDelegate
    // events
    public Motion motion(Closure closure) {
        Motion motion = new Motion()
        motion.closure = closure
        
        slot.addMotion(motion)

        return motion
    }

    public void click(Closure click) {
        slot.click(click)
    }

    public void press(Closure press) {
        slot.press(press)
    }

    public void release(Closure release) {
        slot.release(release)
    }

    public void keypress(Closure press) {
        slot.keypress(press)
    }
}
