package loafers.elements.support

import loafers.elements.Slot
import loafers.elements.Background
import loafers.elements.Border
import java.awt.Graphicsimport java.awt.Graphics2Dimport java.awt.RenderingHints;

import loafers.elements.PaintElementimport javax.swing.JPanel

/**
 * @author Peter De Bruycker
 *
 */
public class SlotPanel extends JPanel {
    private Slot slot
    
    public SlotPanel(Slot slot) {
        assert slot != null, "slot cannot be null"
        this.slot = slot
        
        opaque = false
    }
    
    public void paint(Graphics g) {
        Graphics2D graphics = g.create()

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        slot.contents.findAll { it instanceof Background }.each { it.paint(slot, graphics) }
        slot.contents.findAll { it instanceof Border }.each { it.paint(slot, graphics) }
        
        super.paintComponents(g)

        // now print the shapes
        slot.shapes.each { shape ->
            shape.paint(graphics)
        }
    }
}