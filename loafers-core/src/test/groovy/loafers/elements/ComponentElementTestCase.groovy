package loafers.elements;

import javax.swing.JComponent;


/**
 * Base testcase for ComponentElements.
 * 
 * @author Peter De Bruycker
 */
public abstract class ComponentElementTestCase extends GroovyTestCase {

    private ComponentElement element
    
    protected final void setUp() throws Exception {
        element = createComponentElement()
    }

    protected abstract ComponentElement createComponentElement()

    public void testPreconditions() {
        assert element != null
    }
    
    public void testComponentAlwaysReturnsSameValue() {
        assert element.component == element.component
    }
    
}
