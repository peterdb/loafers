package loafers.elements;

import static java.awt.Color.RED;
import loafers.paint.Color;
import loafers.paint.Pattern;
import groovy.util.GroovyTestCase;

/**
 * Testcase for the Background element.
 * 
 * @author Peter De Bruycker
 */
public class BackgroundTest extends GroovyTestCase {

    public void testPattern() {
        Pattern p = new Color(RED)
        
        Background background = new Background()

        background.pattern = p

        assert p == background.pattern
        assert p == background.styles.pattern
    }
}
