package loafers.text;


/**
 * Testcase for Sup
 * 
 * @author Peter De Bruycker
 */
public class SupTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Sup(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<sup>$innerHtml</sup>"
    }
}
