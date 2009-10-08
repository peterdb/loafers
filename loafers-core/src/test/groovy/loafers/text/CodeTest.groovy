package loafers.text;


/**
 * Testcase for Code
 * 
 * @author Peter De Bruycker
 */
public class CodeTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Code(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<code>$innerHtml</code>"
    }
}
