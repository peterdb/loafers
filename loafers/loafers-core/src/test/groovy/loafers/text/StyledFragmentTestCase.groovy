package loafers.text;

import loafers.elements.TextBlock;

/**
 * @author Peter De Bruycker
 *
 */
public abstract class StyledFragmentTestCase extends TextFragmentTestCase {

    private TextBlock textBlock
    
    private StyledFragment styledFragment
    private PlainFragment plainFragment
    
    protected TextFragment createTextFragment() {
        return createStyledFragment(new PlainFragment("test text"))
    }

    protected abstract StyledFragment createStyledFragment(TextFragment inner)

    protected void doSetUp() throws Exception {
        textBlock = new TextBlock()
        // trigger component creation
        textBlock.component
        
        plainFragment = new PlainFragment("test text")
        styledFragment = createStyledFragment(plainFragment)
    }

    public void testPreconditions3() {
        plainFragment != null
        styledFragment != null
    }
    
    public void testSetTextBlockAlsoOnInnerFragment() {
        styledFragment.textBlock = textBlock

        assert styledFragment.textBlock == textBlock
        assert plainFragment.textBlock == textBlock
    }

    public void testGetAndSetText() {
        styledFragment.text = "new text"

        assert styledFragment.text == "new text"
        assert plainFragment.text == "new text"

        styledFragment.text = ""

        assert styledFragment.text == ""
        assert plainFragment.text == ""
    }

    public void testGetHtmlFragment() {
        assertHtmlFragment(styledFragment, styledFragment.htmlFragment, "test text")

        // nested styles
        styledFragment = createStyledFragment(new Strong(new PlainFragment("strong text")))

        assertHtmlFragment(styledFragment, styledFragment.htmlFragment, "<strong>strong text</strong>")
    }

    protected abstract void assertHtmlFragment(StyledFragment fragment, String htmlFragment, String innerHtml)
}
