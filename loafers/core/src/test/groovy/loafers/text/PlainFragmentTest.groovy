package loafers.text

import groovy.util.GroovyTestCase

/**
 * @author Peter De Bruycker
 */
public class PlainFragmentTest extends GroovyTestCase {
	
	public void testHtmlEncode() {
		assert "abc" == PlainFragment.HTMLEntityEncode("abc");
		assert "a bc\ndef" == PlainFragment.HTMLEntityEncode("a bc\ndef");
		assert "&#60;tag&#62;" == PlainFragment.HTMLEntityEncode("<tag>");
	}
	
}
