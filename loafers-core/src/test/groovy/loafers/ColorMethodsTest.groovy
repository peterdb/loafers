package loafers

import java.awt.Color

/**
 * Testcase for ColorMethods.
 * 
 * @author Peter De Bruycker
 */
public class ColorMethodsTest extends GroovyTestCase {
    private ColorMethods colorMethods
    
    @Override
    protected void setUp() throws Exception {
        colorMethods = new ColorMethods()
    }

    public void testColor() {
        Color color = colorMethods.rgb(1, 2, 3)
        
        assert color.getRed() == 1
        assert color.getGreen() == 2
        assert color.getBlue() == 3
        assert color.getAlpha() == 255

        color = colorMethods.rgb(1, 2, 3, 0.5)

        assert color.getRed() == 1
        assert color.getGreen() == 2
        assert color.getBlue() == 3
        assert color.getAlpha() == 127
    }

    public void testPredefinedColors() {
        // just a sanity test
        assert colorMethods.tomato != null
    }

    public void testPreconditions() {
        assert colorMethods != null
    }

    public void testFromString() {
        assert colorMethods.fromString("#FFF") == colorMethods.rgb(0xFF, 0xFF, 0xFF)
        assert colorMethods.fromString("#A00") == colorMethods.rgb(0xAA, 0x00, 0x00)
        
        assert colorMethods.fromString("#FFFFFF") == colorMethods.rgb(0xFF, 0xFF, 0xFF)
        assert colorMethods.fromString("#AABBCC") == colorMethods.rgb(0xAA, 0xBB, 0xCC)
    }
}
