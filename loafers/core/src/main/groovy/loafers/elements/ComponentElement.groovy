package loafers.elements;

import javax.swing.JComponent;
import javax.swing.BorderFactoryimport java.awt.Component
import java.awt.Dimension
public abstract class ComponentElement extends Element {
	private JComponent component
	
	public final JComponent getComponent() {
		if(component == null) {
			component = createComponent()
			assert component != null, "createComponent cannot return null"
		}
		return component
	}
	
	protected Dimension getPreferredSize(Dimension parentSize) {
		return component.getPreferredSize()
	}
	
	protected abstract JComponent createComponent();
	
	public hide() {
		getComponent().visible = false
	}
	
	public show() {
		getComponent().visible = true
	}
	
	public toggle() {
		getComponent().visible = !component.visible
	}
}
