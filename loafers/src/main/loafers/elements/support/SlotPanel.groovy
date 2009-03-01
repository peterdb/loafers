package loafers.elements.support

import loafers.elements.Slotimport java.awt.Graphicsimport java.awt.Graphics2Dimport loafers.elements.PaintElementimport javax.swing.JPanel

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
		g.clearRect(0,0,getWidth(),getHeight())
		
		if(slot != null) {
			Graphics2D graphics = g.create();
			
			for (e in slot.getContents()) {
				if(e instanceof PaintElement) {
					e.paint(slot, graphics);
				}
			}
			
			graphics.dispose()
			
			super.paintChildren(g)
		}
	}
}