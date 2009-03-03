package loafers.builder

import loafers.elements.*
import loafers.text.*
import loafers.elements.TextBlock
/**
 * @author Peter De Bruycker
 *
 */
public class TextBlockFactory extends ElementFactory  {
 	private int size
 
 	public TextBlockFactory(int size) {
 		super(TextBlock)
 		this.size = size
 	}
 	
 	protected void registerDefaults(Object value, Map styles) {
    	if (value != null) {
    		styles.text = value
    	}
    	
    	if (!styles.size) {
    		styles.size = size
    	}
 	}
}
