package loafers.elements

import javax.swing.JCheckBox
import javax.swing.JComponent
	private Closure currentClick

	protected JComponent createComponent() {
		return new JCheckBox()
	}
	
	public JCheckBox getCheckBox() {
		return component
	}
	
	public click(Closure c) {
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
	
	public void style(Map styles) {
		super.style(styles)
	}
}