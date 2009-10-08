package loafers.text;


/**
 * Testcase for Strong
 * 
 * @author Peter De Bruycker
 */
public class StrongTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Strong(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<strong>$innerHtml</strong>"
    }
}
