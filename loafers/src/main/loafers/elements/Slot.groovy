package loafers.elements

import javax.swing.JComponentimport loafers.elements.support.SlotPanelimport java.awt.Dimension
import java.awt.event.MouseEventimport java.awt.event.MouseAdapterimport loafers.events.Releaseimport java.awt.Graphicsimport javax.swing.JPanelimport java.awt.LayoutManagerimport java.awt.Graphics2Dimport loafers.events.Clickimport java.awt.event.MouseListener
/**
 * @author Peter De Bruycker
 */
public abstract class Slot extends ComponentElement implements MouseListener {
	private List elements = []
	private List clicks = []
	private List releases = []
	
	private LayoutManager layout
	
	public Slot(LayoutManager layout) {
		this.layout = layout
	}
	
	protected JComponent createComponent() {
		SlotPanel panel = new SlotPanel(this)
		
		panel.layout = layout
		
		return panel
	}
	
	public JPanel getPanel() {
		return component
	}
	
	public void addClick(Click click) {
		clicks.add(click)
	}
	
	public void addRelease(Release release) {
		releases.add(release)
	}
	
	public List getContents() {
		return elements
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
		
		panel.removeAll()
		elements.each({ 
			if (it instanceof ComponentElement) {
				panel.add(it.component, it)
			} 
		})
		
		update()
	}
	
	protected String createConstraints(Element e) {
		return null
	}
	
	public remove(Element e) {
		assert e != null : "element cannot be null"
		assert elements.contains(e) : "not my element"
		
		elements.remove(e)
		
		if(e instanceof ComponentElement) {
			panel.remove(e.component)
		}
		
		update()
	}
	
	public void update() {
		panel.revalidate()
		panel.repaint()
	}
	
	public focus() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		// not used
	}
	
	public void mousePressed(MouseEvent e) {
		clicks.each({it.click(e)})
	}
	
	public void mouseReleased(MouseEvent e) {
		releases.each({it.release(e)})
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
}
