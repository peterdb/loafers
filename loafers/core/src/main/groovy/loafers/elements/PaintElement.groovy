package loafers.elements;

import java.awt.Graphics2D


	private boolean visible
	
	public hide() {
		visible = false
		parent.update()
	}
	
	public show() {
		visible = true
		parent.update()
	}
	
	public toggle() {
		visible = !visible
		parent.update()
	}
	
	protected abstract void paint(Slot parent, Graphics2D g)
	
}