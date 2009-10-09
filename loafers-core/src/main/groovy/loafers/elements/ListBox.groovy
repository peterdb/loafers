package loafers.elements

import javax.swing.JComboBox

/**
 * @author Peter De Bruycker
 */
public class ListBox extends FocusableComponentElement {
	
	protected JComponent createComponent() {
		JComboBox comboBox = new JComboBox()
		
		comboBox.addItemListener({ evt -> 
			if (evt.stateChange == ItemEvent.SELECTED && getStyles().change) {
				getStyles().change(this)
			} 
		} as ItemListener)
		
		return comboBox
	}
	
	public JComboBox getComboBox() {
		return component
	}
	
	public setItems(List items) {
		style(['items': items])
	}
	
	public List getItems() {
		return styles.items
	}
	
	protected void doStyle(Map styles) {
        super.doStyle(styles)
        
		if(styles.items) {
			comboBox.setModel(new DefaultComboBoxModel(styles.items.toArray()))
		}
		
		if(styles.choose) {
			comboBox.selectedItem = styles.choose
		}
	}
	
	public change(Closure c) {
		style(['change': c])
	}
	
	public void choose(String item) {
		style(['choose': item])
	}
	
	public String getText() {
		return comboBox.selectedItem
	}
	
	
}