package loafers.builder

import loafers.elements.Image
/**
 * @author Peter De Bruycker
 */
class ImageFactory extends ElementFactory  {
	public ImageFactory() {
		super(Image)
	}
	
	protected void registerDefaults(Object value, Map styles) {
		assert value == null || value instanceof String
		
		if(value != null) {
			styles.path = value
		}
	}
}
