package loafers.text;


/**
 * Testcase for Sub
 * 
 * @author Peter De Bruycker
 */
public class SubTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Sub(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<sub>$innerHtml</sub>"
    }
}
