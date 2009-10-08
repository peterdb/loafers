package loafers.text;


/**
 * Testcase for Link
 * 
 * @author Peter De Bruycker
 */
public class LinkTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Link(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<a href='${System.identityHashCode(fragment)}'>$innerHtml</a>"
    }
}
