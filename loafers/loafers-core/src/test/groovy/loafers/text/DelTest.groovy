package loafers.text;


/**
 * Testcase for Del
 * 
 * @author Peter De Bruycker
 */
public class DelTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Del(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<span style=\"text-decoration: line-through;\">$innerHtml</span>"
    }
}
