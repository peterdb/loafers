package loafers.elements

import javax.swing.JButtonimport java.awt.event.ActionListenerimport javax.swing.JComponent
public class Button extends FocusableComponentElement {
	private Closure currentClick

	protected JComponent createComponent() {
		return new JButton()
	}
	
	public JButton getButton() {
		return component
	}
	
	public setText(text) {
		button.text = text
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
	
	public void style(Map styles) {
		super.style(styles)
		
		if (styles.text) {
			text = styles.text
		}
	}
}