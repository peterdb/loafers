package loafers.elements

import java.util.Map;

import javax.swing.JButton;

import loafers.LoafersClosureDelegate;
import javax.swing.JComponent;
import java.awt.event.ActionListener;

public class Button extends FocusableComponentElement {
	protected JComponent createComponent() {
		JButton button = new JButton()

		button.addActionListener({ evt -> 
			if (styles.click) {
			    Closure clone = styles.click.clone()
			    clone.resolveStrategy = Closure.DELEGATE_FIRST

			    clone.delegate = new LoafersClosureDelegate(parent)
				clone.call(this)
			} 
		} as ActionListener)
		
		return button
	}
	
	public JButton getButton() {
		return component
	}
	
	public setText(text) {
		style(['text': text])
	}
	
	public String getText() {
		return styles.text
	}
	
	public void click(Closure c) {
		style(['click': c])
	}
	
	protected void doStyle(Map styles) {
	    super.doStyle(styles)
	    
		if (styles.text) {
			button.text = text
		}
	}
}