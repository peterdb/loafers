package loafers.elements.support

import loafers.elements.Slot
import loafers.elements.Background
import loafers.elements.Border
import java.awt.Graphicsimport java.awt.Graphics2Dimport java.awt.RenderingHints;

import loafers.elements.PaintElementimport javax.swing.JPanel

/**
 * A Canvas holds all elements and art.
 * 
 * @author Peter De Bruycker
 */
public class Canvas extends JPanel {
    private Slot slot
    
    public Canvas(Slot slot) {
        assert slot != null, "slot cannot be null"
        this.slot = slot
        
        opaque = false
    }
    
    public void paint(Graphics g) {
        Graphics2D graphics = g.create()

        // TODO are there other rendering hints that need to be set?
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // backgrounds at the bottom 
        slot.contents.findAll { it instanceof Background }.each { it.paint(slot, graphics) }

        // then the shapes
        slot.shapes.each { shape ->
            shape.paint(graphics)
        }

        // borders go above the shapes
        slot.contents.findAll { it instanceof Border }.each { it.paint(slot, graphics) }

        // at last paint the components
        super.paintComponents(g)

        graphics.dispose()
    }
}