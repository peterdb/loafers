package loafers.text

import groovy.util.GroovyTestCase

/**
 * Testcase for PlainFragment
 *
 * @author Peter De Bruycker
 */
public class PlainFragmentTest extends TextFragmentTestCase {

    protected TextFragment createTextFragment() {
        return new PlainFragment("test")
    }
    
	public void testHtmlEncode() {
		assert "abc" == PlainFragment.HTMLEntityEncode("abc");
		assert "a bc\ndef" == PlainFragment.HTMLEntityEncode("a bc\ndef");
		assert "a b,c\ndef." == PlainFragment.HTMLEntityEncode("a b,c\ndef.");
		assert "&#60;tag&#62;" == PlainFragment.HTMLEntityEncode("<tag>");
	}

	public void testGetAndSetText() {
	    PlainFragment fragment =new PlainFragment("initial text")

	    assert fragment.text == "initial text"

		fragment.text = ""

	    assert fragment.text == ""

	    fragment.text = "new text"

		assert fragment.text == "new text"
	}

	public void testGetHtmlFragment() {
	    PlainFragment fragment =new PlainFragment("some text")

	    assert fragment.htmlFragment == "some text"

		fragment.text = "<"

	    assert fragment.htmlFragment == "&#60;"
	}
	
}
