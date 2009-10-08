package loafers.paint;

import static java.awt.Color.BLACK;

import groovy.util.GroovyTestCase;

/**
 * Testcase for Color.
 * 
 * @author Peter De Bruycker
 */
public class ColorTest extends GroovyTestCase {

    public void testBlah() {
        Color color = new Color(BLACK)

        assert BLACK == color.color
    }
    
}
