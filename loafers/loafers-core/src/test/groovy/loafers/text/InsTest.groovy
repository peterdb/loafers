package loafers.text;


/**
 * Testcase for Ins
 * 
 * @author Peter De Bruycker
 */
public class InsTest extends StyledFragmentTestCase {

    protected StyledFragment createStyledFragment(TextFragment inner) {
        return new Ins(inner)
    }

    @Override
    protected void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml) {
        assert htmlFragment == "<u>$innerHtml</u>"
    }
}
