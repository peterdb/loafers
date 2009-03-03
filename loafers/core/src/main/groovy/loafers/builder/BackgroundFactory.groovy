package loafers.builder

import loafers.elements.Background

/**
 * @author Peter De Bruycker
 */
public class BackgroundFactory extends ElementFactory  {
	public BackgroundFactory() {
		super(Background)
	}

	protected void registerDefaults(Object value, Map styles) {
    	if(value != null) {
    		styles.color = value
    	}
	}
}