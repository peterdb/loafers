package loafers.elements;

import javax.swing.JComboBox;


/**
 * @author Peter De Bruycker
 *
 */
public class ListBoxTest extends ComponentElementTestCase {

    protected ComponentElement createComponentElement() {
        return new ListBox();
    }
    
    public void testComponent() {
        ListBox listBox = new ListBox()

        JComboBox comboBox = listBox.comboBox

        assert comboBox != null
        assert comboBox == listBox.component
    }
    
    public void testItems() {
        ListBox listBox = new ListBox()

        List items = ["banana", "orange", "apple", "lemon"]

        listBox.items = items

        assert listBox.items == items

        JComboBox comboBox = listBox.comboBox

        items.eachWithIndex { item, i -> 
            assert comboBox.getItemAt(i) == item
        }
    }
    
}
