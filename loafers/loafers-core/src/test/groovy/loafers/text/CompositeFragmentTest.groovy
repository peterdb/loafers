package loafers.text

import loafers.elements.TextBlock;

/**
 * Testcase for CompositeFragment
 * 
 * @author Peter De Bruycker
 */
public class CompositeFragmentTest extends TextFragmentTestCase {

    private TextBlock textBlock
    private PlainFragment plainFragment
    private Strong strongFragment
    
    protected void doSetUp() throws Exception {
        textBlock = new TextBlock()
        // trigger component creation
        textBlock.component

        plainFragment = new PlainFragment("plain")
        strongFragment = new Strong(new PlainFragment("strong"))
    }

    public void testPreconditions2() {
        assert textBlock != null

        assert plainFragment != null
        assert strongFragment != null
    }

    protected TextFragment createTextFragment() {
        return new CompositeFragment([new PlainFragment("text")]) 
    }

    public void testConstructor() {
        CompositeFragment compositeFragment = new CompositeFragment([plainFragment, strongFragment])

        assert compositeFragment.fragments == [plainFragment, strongFragment]
    }
    
    public void testChangeTextOnInnerFragment() {
        CompositeFragment compositeFragment = new CompositeFragment([plainFragment, strongFragment])

        plainFragment.text = "new plain text,"
        strongFragment.text = " new strong text"

        assert plainFragment.text == "new plain text,"
        assert strongFragment.text == " new strong text"

        assert compositeFragment.text == "new plain text, new strong text"
    }

    public void testSetText() {
        CompositeFragment compositeFragment = new CompositeFragment([plainFragment, strongFragment])

        compositeFragment.text = "test"

        assert compositeFragment.text == "test"
        assert compositeFragment.fragments.size == 1
        assert compositeFragment.fragments[0] instanceof PlainFragment
        assert compositeFragment.fragments[0].text == "test"
    }

    public void testSetTextBlockAlsoSetsOnChildFragments() {
        CompositeFragment compositeFragment = new CompositeFragment([plainFragment, strongFragment])

        compositeFragment.textBlock = textBlock

        assert plainFragment.textBlock == textBlock
        assert strongFragment.textBlock == textBlock
    }
    
}
