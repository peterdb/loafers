package loafers.elements


import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
public class Check extends FocusableComponentElement {
	private Closure currentClick

	protected JComponent createComponent() {
		return new JCheckBox()
	}
	
	public JCheckBox getCheckBox() {
		return component
	}
	
	public void click(Closure c) {
		if (currentClick != null) {
			button.removeActionListener(currentClick as ActionListener)
		}

		if (c != null) {
			currentClick = { c(this) }
			button.addActionListener(currentClick as ActionListener)
		}	
	}
	
	public void setChecked(boolean checked) {
		checkBox.selected = checked
	}
	
	public boolean isChecked() {
		return checkBox.selected
	}

	protected void doStyle(Map styles) {
        super.doStyle(styles)
	}
}