package loafers.elements;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.JComponent;

public abstract class ComponentElement extends Element {
	private JComponent component
	
	public JComponent getComponent() {
		if(component == null) {
			component = createComponent()
			assert component != null, "createComponent cannot return null"
		}
		return component
	}

	protected void doStyle(Map styles) {
	    assert styles != null

	    // trigger component creation first, so styles that affect the component will work
	    getComponent()
	}
	
	protected Dimension getPreferredSize(Dimension parentSize) {
		return component.getPreferredSize()
	}
	
	protected abstract JComponent createComponent();
	
	public hide() {
		component.visible = false
	}
	
	public show() {
		component.visible = true
	}
	
	public toggle() {
		component.visible = !component.visible
	}

    public Dimension getSize() {
        return component.size;
    }
}
