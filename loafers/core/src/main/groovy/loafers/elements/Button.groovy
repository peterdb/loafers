package loafers.elements

import javax.swing.JButtonimport java.awt.event.ActionListenerimport javax.swing.JComponent
public class Button extends FocusableComponentElement {
	protected JComponent createComponent() {
		JButton button = new JButton()
		
		button.addActionListener({ evt -> 
			if (styles().click) {
				styles().click(this)
			} 
		} as ActionListener)
		
		return button
	}
	
	public JButton getButton() {
		return component
	}
	
	public setText(text) {
		button.text = text
	}
	
	public String getText() {
		return button.text
	}
	
	public click(Closure c) {
		style(['click':c])
	}
	
	public void style(Map styles) {
		super.style(styles)
		
		if (styles.text) {
			text = styles.text
		}
	}
}