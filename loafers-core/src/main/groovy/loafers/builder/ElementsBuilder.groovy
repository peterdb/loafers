package loafers.builder

import java.util.Map;

import javax.swing.JComponent

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
import loafers.elements.TextBlock;
import loafers.elements.Check;
import loafers.elements.EditLine;
import loafers.elements.EditBox;

import loafers.paint.Pattern;
import loafers.paint.Color;

import loafers.text.Del;
import loafers.text.Code;
import loafers.text.Em;
import loafers.timer.Every;
import loafers.text.Link;
import loafers.text.Strong;
import loafers.text.TextFragment;
import loafers.text.PlainFragment;
import loafers.text.CompositeFragment;

public class ElementsBuilder {

    private Slot slot
    private Closure addStrategy

    public void setSlot(Slot slot) {
        this.slot = slot
    }

    public Slot getSlot() {
        return slot
    }

    public void setAddStrategy(Closure addStrategy) {
        this.addStrategy = addStrategy;
    }

    public Closure getAddStrategy() {
        return addStrategy;
    }

    // TODO test to see if the manipulation methods are still necessary here, because the LoafersClosureDelegate also delegates to the slot itself
    // this means that we can only keep the element creation methods
    public void prepend(Element target, Closure closure) {
        slot.prepend(closure)
    }

    public void before(Element target, Closure closure) {
        slot.before(target, closure)
    }

    public void after(Element target, Closure closure) {
        slot.after(target, closure)
    }

    public void append(Element target, Closure closure) {
        slot.append(closure)
    }
    
    private void addElement(Element e) {
        assert e != null

        if(addStrategy == null) {
            slot.append(e)
        } else {
            addStrategy(e)
        }
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

    public TextBlock banner(Object...content = []) {
        return banner([:], content)
    }
    
    public TextBlock banner(Map styles, Object...content = []) {
        return textBlock(content, styles, 48)
    }

    public TextBlock title(Object...content = []) {
        return title([:], content)
    }
    
    public TextBlock title(Map styles, Object...content = []) {
        return textBlock(content, styles, 34)
    }

    public TextBlock subtitle(Object...content = []) {
        return subtitle([:], content)
    }
    
    public TextBlock subtitle(Map styles, Object...content = []) {
        return textBlock(content, styles, 26)
    }

    public TextBlock tagline(Object...content = []) {
        return tagline([:], content)
    }
    
    public TextBlock tagline(Map styles, Object...content = []) {
        return textBlock(content, styles, 18)
    }

    public TextBlock caption(Object...content = []) {
        return caption([:], content)
    }
    
    public TextBlock caption(Map styles, Object...content = []) {
    	return textBlock(content, styles, 14)
    }

    public TextBlock para(Object...fragments = []) {
        return para([:], fragments)
    }
    
    public TextBlock para(Map styles, Object...fragments = []) {
    	return textBlock(fragments, styles, 12)
    }

    public TextBlock inscription(Object...content = []) {
        return inscription([:], content)
    }
    
    public TextBlock inscription(Map styles, Object...content = []) {
        return textBlock(content, styles, 10)
    }

    private TextBlock textBlock(Object... fragments, Map styles, int size) {
    	TextBlock textBlock = new TextBlock()

    	if (fragments != null) {
    		styles.text = createTextFragment(fragments)
    	}
    	
    	if (!styles.size) {
    		styles.size = size
    	}

    	textBlock.style(styles)
    	
        addElement(textBlock)
        
    	return textBlock
    }

    private TextFragment createTextFragment(Object... fragments) {
        if(fragments.size() == 1) {
            if(fragments[0] instanceof TextFragment)  {
                return fragments[0]
            }else {
                return new PlainFragment(fragments[0])
            }
        }
        
        return new CompositeFragment(fragments.collect{ it ->
            if(it instanceof TextFragment) {
                return it
            } else {
                return new PlainFragment(it.toString())
            }
        })
    }

    public Strong strong(Object... fragments) {
        return new Strong(createTextFragment(fragments))
    }

    public Code code(Object... fragments) {
        return new Code(createTextFragment(fragments))
    }

    public Em em(Object... fragments) {
        return new Em(createTextFragment(fragments))
    }

    public Del del(Object... fragments) {
        return new Del(createTextFragment(fragments))
    }

    public Link link(Object fragment, Closure click = null) {
        return new Link(createTextFragment(fragment), click)
    }
    
    public Link link(Object... fragments, Closure click = null) {
        return new Link(createTextFragment(fragments), click)
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
