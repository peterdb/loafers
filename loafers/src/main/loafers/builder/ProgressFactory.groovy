package loafers.builder

import loafers.elements.Progress
/**
 * @author Peter De Bruycker
 */
public class ProgressFactory extends ElementFactory  {
	public ProgressFactory() {
		super(Progress)
	}
	
	protected void registerDefaults(Object value, Map styles) {
		if(!styles.width) {
			styles.width = 200
		}
	}
}
