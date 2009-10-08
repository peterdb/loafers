package loafers

import groovy.util.GroovyTestCaseimport loafers.text.Codeimport loafers.text.TextFragmentimport loafers.elements.Appimport org.codehaus.groovy.runtime.InvokerHelper

/**
 * Testcase for Loafers
 * 
 * @author Peter De Bruycker
 */
public class LoafersTest extends GroovyTestCase {
    
    public void testApp() {
        boolean closureRun = false
        def closureDelegate
        
        App app = Loafers.app { 
            closureRun = true
            closureDelegate = delegate
        }
        
        assert app != null
        assert app.title == "Loafers"
        assert app.frame.title == "Loafers"
        assert app.frame.visible
        
        // closure assertions
        assert closureRun, "the closure has not been run"

        // TODO assert the delegate is a LoafersClosureDelegate instance with the correct slot field
        //assert app == closureDelegate, "the delegate of the closure must be the app"
    }
    
    public void testApp2() {
        App app = Loafers.app { 
            button "this is the button", { println "hello world" }
            button "jup"
        }
        
        assert app.slot != null
    }
    
    
}
