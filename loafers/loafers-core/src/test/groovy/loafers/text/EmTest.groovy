package loafers.text;


/**
 * Testcase for Em
 * 
 * @author Peter De Bruycker
 */
public class EmTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Em(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<em>$innerHtml</em>"
    }
}
