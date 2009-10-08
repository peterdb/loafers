package loafers.text;

import loafers.elements.TextBlock;

/**
 * Abstract Testcase for TextFragment
 * 
 * @author Peter De Bruycker
 */
public abstract class TextFragmentTestCase extends GroovyTestCase {

    private TextFragment textFragment
    
    protected final void setUp() throws Exception {
        textFragment = createTextFragment()

        doSetUp()
    }

    protected void doSetUp() throws Exception {
        
    }

    public final void testPreconditions() {
        assert textFragment != null
    }
    
    public void testGetAndTextBlock() {
        TextBlock textBlock = new TextBlock()

        assert textFragment.textBlock == null

        textFragment.textBlock = textBlock

        assert textFragment.textBlock == textBlock
    }
    
}
