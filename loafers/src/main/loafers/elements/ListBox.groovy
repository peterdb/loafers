package loafers.elements

import javax.swing.JComboBoximport javax.swing.DefaultComboBoxModelimport java.awt.event.ItemListenerimport java.awt.event.ItemEventimport javax.swing.JComponent

/**
 * @author Peter De Bruycker
 */
public class ListBox extends FocusableComponentElement {
	
	protected JComponent createComponent() {
		JComboBox comboBox = new JComboBox()
		
		comboBox.addItemListener({ evt -> 
			if (evt.stateChange == ItemEvent.SELECTED && styles().change) {
				styles().change(this)
			} 
		} as ItemListener)
		
		return comboBox
	}
	
	public JComboBox getComboBox() {
		return component
	}
	
	public setItems(List items) {
		style(['items', items])
	}
	
	public List getItems() {
		return styles.items
	}
	
	public void style(Map styles) {
		super.style(styles)
		
		if(styles.items) {
			comboBox.setModel(new DefaultComboBoxModel(styles.items.toArray()))
		}
		
		if(styles.choose) {
			comboBox.selectedItem = item
		}
	}
	
	public change(Closure c) {
		style(['change':c])
	}
	
	public void choose(String item) {
		style(['choose':item])
	}
	
	public String getText() {
		return comboBox.selectedItem
	}
	
	
}
