package loafers.elements
import java.awt.LayoutManager;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import groovy.lang.Closure;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

import loafers.core.LoafersClosureDelegate;
import loafers.elements.support.Canvas;
import loafers.events.Click;
import loafers.art.AbstractShape;
import loafers.events.Release;

/**
 * @author Peter De Bruycker
 */
public abstract class Slot extends ComponentElement implements KeyListener {
    private List elements = []
    List shapes = []
    
    Closure click
    Closure press
    Closure release

    private Closure keypress
    
    private LayoutManager layout
    private Canvas canvas
    
    public Slot(LayoutManager layout) {
        this.layout = layout
    }
    
    protected JComponent createComponent() {
        canvas = new Canvas(this)
        
        canvas.layout = layout

        canvas.addKeyListener(this)
        
        def mouseEventHandler = [
            mouseClicked: { e ->
                if(click != null) {
                    switch (click.parameterTypes.length) {
                        case 0: click.call(); break;
                        case 1: click.call(e.getButton()); break;
                        default: click.call(e.getButton(), e.getX(), e.getY()); break; // if one param, the closure is called with the field value
                    }    
                    e.consume()
                }
            },
            mouseEntered: {},
            mouseExited: {},
            mousePressed: { e ->
                if(press != null) {
                    switch (press.parameterTypes.length) {
                        case 0: press.call(); break;
                        case 1: press.call(e.getButton()); break;
                        default: press.call(e.getButton(), e.getX(), e.getY()); break; // if one param, the closure is called with the field value
                    }    
                    e.consume()
                }
            },
            mouseReleased: { e ->
                if(release != null) {
                    switch (release.parameterTypes.length) {
                        case 0: release.call(); break;
                        case 1: release.call(e.getButton()); break;
                        default: release.call(e.getButton(), e.getX(), e.getY()); break; // if one param, the closure is called with the field value
                    }    
                    e.consume()
                }
            }
        ]

        canvas.addMouseListener(mouseEventHandler as MouseListener)
        
//        JScrollPane scrollPane = new JScrollPane(canvas)
//        scrollPane.opaque = false
//        scrollPane.border = BorderFactory.createEmptyBorder()
//        
//        scrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
//        scrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_NEVER
//        
//        return scrollPane

		return canvas
    }
    
    public Canvas getCanvas() {
        return canvas
    }
    
    public void click(Closure click) {
        this.click = click
    }

    public void press(Closure press) {
        this.press = press
    }
    
    public void release(Closure release) {
        this.release = release
    }

    public void keypress(Closure press) {
        this.keypress = keypress
    }

    /**
     * Returns the elements
     */
    public List getContents() {
        return elements
    }

    public void clear(Closure c) {
        assert c != null

        // TODO correct to do this here? should also happen on all style invocations on an element + on all manipulations on a slot (append, prepend, clear, ...)
        SwingUtilities.invokeLater({
            clear()
            append(c)
        } as Runnable)
    }
    
    public void clear() {
        elements.each { element ->
            element.parent = null
        }

        shapes.clear()
    	elements.clear()
    	canvas.removeAll()    	
    	update( )
    }
    
    public void prepend(Closure c) {
        assert c != null

        add(c, { element -> prepend(element) })
    }

    public void before(Element e, Closure c) {
        assert e != null
        assert c != null

        add(c, { element -> before(e, element) })
    }

    public void after(Element e, Closure c) {
        assert e != null
        assert c != null

        add(c, { element -> after(e, element) })
    }

    public void append(Closure c) {
        assert c != null

        add(c, { element -> append(element) })
    }

    private void add(Closure c, Closure addStrategy) {
        assert c != null
        assert addStrategy != null

        new LoafersClosureDelegate(this, addStrategy).with((c))
    }

    public void append(Element e) {
        add(elements.size(), e)
    }
    
    public void prepend(Element e) {
        add(0, e)
    }
    
    public void before(Element target, Element e) {
        assert target != null : "target cannot be null"
        assert elements.contains(target) : "target not added to this slot"

        add(elements.indexOf(target), e)
    }
    
    public void after(Element target, Element e) {
        assert target != null : "target cannot be null"
        assert elements.contains(target) : "target not added to this slot"
        
        add(elements.indexOf(target)+1, e)
    }
    
    private add(int index, Element e) {
        assert e != null : "element cannot be null"
        assert !elements.contains(e) : "element already added"
        assert index >= 0 : "index must be positive"
        
        elements.add(index, e)
        e.parent = this

        canvas.removeAll()
        elements.each { element ->
            if (element instanceof ComponentElement) { 
                canvas.add(element.component, element)
            }  
        }
        
        update()
    }
    
    public remove(Element e) {
        assert e != null : "element cannot be null"
        assert elements.contains(e) : "not my element"
        
        elements.remove(e)
        e.parent = null
        
        if(e instanceof ComponentElement) {
            canvas.remove(e.component)
        }
        
        update()
    }
    
    public void update() {
        // TODO correct place to do this?
        
        SwingUtilities.invokeLater({
            canvas.revalidate()
            canvas.repaint()
        } as Runnable)
    }
    
    public focus() {
        
    }

    public void keyPressed(KeyEvent e) {
        println "keypressed"
        if(keypressed != null) {
            keypressed.call(e.getKeyCode())
            e.consume()
        }
    }

    public void keyReleased(KeyEvent e) {
        println "keyreleased"
    }

    public void keyTyped(KeyEvent e) {
        println "keyTyped"
    }


    protected void doStyle(Map styles) {
        super.doStyle(styles);
    }

    public void addShape(AbstractShape shape) {
        assert shape != null

        shapes.add(shape)
    }
}
