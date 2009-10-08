package loafers.elements;

import loafers.Loafers;

import groovy.util.GroovyTestCase;

/**
 * Testcase for App.
 * 
 * @author Peter De Bruycker
 */
public class AppTest extends GroovyTestCase {

    public void testTitle() {
        App app = new App()

        assert null == app.title
        assert null == app.styles.title
        
        app.title = "test"
        assert "test" == app.title
        assert "test" == app.styles.title

        app.style([title:"new title"])
        assert "new title" == app.title
        assert "new title" == app.styles.title
    }
}
