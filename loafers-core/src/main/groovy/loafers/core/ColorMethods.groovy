package loafers.core

import java.awt.Color;
import java.util.regex.Matcher;

import loafers.paint.Gradient;

/**
 * Color methods and predefined colors.
 * <p>
 * Colors are presented as getters, so we can reference the colors by their name (ie tomato, aqua, ...).
 * <p>
 * Predefined color definitions taken from Shoes.
 * 
 * @author Peter De Bruycker
 */
public class ColorMethods {

    // TODO split in two classes: ColorMethods + ColorDefinitions
    // TODO create methods for all colors + alpha
    
    /**
     * Create a color for the given red, green and blue values
     */
    public Color rgb(Integer red, Integer green, Integer blue) {
        return new Color(red, green, blue)
    }

    /**
     * Create a color for the given red, green and blue values and an alpha value
     */
    public Color rgb(Integer red, Integer green, Integer blue, BigDecimal alpha) {
        return new Color(red, green, blue, (int) (alpha * 255))
    }

    /**
     * Create a new color by taking the red, green and blue from given color and applying
     * the alpha value. 
     */
    public Color color(Color color, BigDecimal alpha) {
        assert color != null
        assert alpha != null

        return rgb(color.getRed(), color.getGreen(), color.getBlue(), alpha)
    }

    /**
     * Create a color from a html color representation (3 or 6 digits)
     */
    public Color fromString(String string) {
        assert string != null

        // string must be a html RGB notation (3-digit or 6-digit)

        Matcher threeDigits = string =~ /#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])/
        Matcher sixDigits = string =~ /#([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})/

        if(threeDigits.matches()) {
            int r = Integer.decode("0x${threeDigits[0][1]+threeDigits[0][1]}");
            int g = Integer.decode("0x${threeDigits[0][2]+threeDigits[0][2]}");
            int b = Integer.decode("0x${threeDigits[0][3]+threeDigits[0][3]}");

            return rgb(r, g, b)
        } 

        if(sixDigits.matches()) {
            int r = Integer.decode("0x${sixDigits[0][1]}");
            int g = Integer.decode("0x${sixDigits[0][2]}");
            int b = Integer.decode("0x${sixDigits[0][3]}");

            return rgb(r, g, b)
        }
        
        throw new IllegalArgumentException("Not a valid rgb notation: $string")
    }

    public Gradient gradient(Color color1, Color color2) {
        assert color1 != null
        assert color2 != null
        
        return new Gradient(color1, color2)
    }

    public Color aliceblue(BigDecimal alpha) {
        return color(aliceblue, alpha)
    }

    public Color getAliceblue() { rgb(240, 248, 255) }
    public Color getAntiquewhite() { rgb(250, 235, 215) }
    public Color getAqua() { rgb(0, 255, 255) }
    public Color getAquamarine() { rgb(127, 255, 212) }
    public Color getAzure() { rgb(240, 255, 255) }
    public Color getBeige() { rgb(245, 245, 220) }
    public Color getBisque() { rgb(255, 228, 196) }

    public Color black(BigDecimal alpha) {
        return color(black, alpha)
    }

    public Color getBlack() { rgb(0, 0, 0) }
    public Color getBlanchedalmond() { rgb(255, 235, 205) }
    public Color getBlue() { rgb(0, 0, 255) }
    public Color getBlueviolet() { rgb(138, 43, 226) }
    public Color getBrown() { rgb(165, 42, 42) }
    public Color getBurlywood() { rgb(222, 184, 135) }
    public Color getCadetblue() { rgb(95, 158, 160) }
    public Color getChartreuse() { rgb(127, 255, 0) }
    public Color getChocolate() { rgb(210, 105, 30) }
    public Color getCoral() { rgb(255, 127, 80) }
    public Color getCornflowerblue() { rgb(100, 149, 237) }
    public Color getCornsilk() { rgb(255, 248, 220) }
    public Color getCrimson() { rgb(220, 20, 60) }
    public Color getCyan() { rgb(0, 255, 255) }
    public Color getDarkblue() { rgb(0, 0, 139) }
    public Color getDarkcyan() { rgb(0, 139, 139) }
    public Color getDarkgoldenrod() { rgb(184, 134, 11) }
    public Color getDarkgray() { rgb(169, 169, 169) }

    public Color darkgreen(BigDecimal alpha) {
        return color(darkgreen, alpha)
    }
    
    public Color getDarkgreen() { rgb(0, 100, 0) }
    public Color getDarkkhaki() { rgb(189, 183, 107) }
    public Color getDarkmagenta() { rgb(139, 0, 139) }
    public Color getDarkolivegreen() { rgb(85, 107, 47) }
    public Color getDarkorange() { rgb(255, 140, 0) }
    public Color getDarkorchid() { rgb(153, 50, 204) }
    public Color getDarkred() { rgb(139, 0, 0) }
    public Color getDarksalmon() { rgb(233, 150, 122) }
    public Color getDarkseagreen() { rgb(143, 188, 143) }
    public Color getDarkslateblue() { rgb(72, 61, 139) }
    public Color getDarkslategray() { rgb(47, 79, 79) }
    public Color getDarkturquoise() { rgb(0, 206, 209) }
    public Color getDarkviolet() { rgb(148, 0, 211) }
    public Color getDeeppink() { rgb(255, 20, 147) }
    public Color getDeepskyblue() { rgb(0, 191, 255) }
    public Color getDimgray() { rgb(105, 105, 105) }
    public Color getDodgerblue() { rgb(30, 144, 255) }
    public Color getFirebrick() { rgb(178, 34, 34) }
    public Color getFloralwhite() { rgb(255, 250, 240) }
    public Color getForestgreen() { rgb(34, 139, 34) }
    public Color getFuchsia() { rgb(255, 0, 255) }
    public Color getGainsboro() { rgb(220, 220, 220) }
    public Color getGhostwhite() { rgb(248, 248, 255) }
    public Color getGold() { rgb(255, 215, 0) }
    public Color getGoldenrod() { rgb(218, 165, 32) }
    public Color getGray() { rgb(128, 128, 128) }
    public Color getGreen() { rgb(0, 128, 0) }
    public Color getGreenyellow() { rgb(173, 255, 47) }
    public Color getHoneydew() { rgb(240, 255, 240) }
    public Color getHotpink() { rgb(255, 105, 180) }
    public Color getIndianred() { rgb(205, 92, 92) }
    public Color getIndigo() { rgb(75, 0, 130) }
    public Color getIvory() { rgb(255, 255, 240) }
    public Color getKhaki() { rgb(240, 230, 140) }
    public Color getLavender() { rgb(230, 230, 250) }
    public Color getLavenderblush() { rgb(255, 240, 245) }
    public Color getLawngreen() { rgb(124, 252, 0) }
    public Color getLemonchiffon() { rgb(255, 250, 205) }
    public Color getLightblue() { rgb(173, 216, 230) }
    public Color getLightcoral() { rgb(240, 128, 128) }
    public Color getLightcyan() { rgb(224, 255, 255) }
    public Color getLightgoldenrodyellow() { rgb(250, 250, 210) }
    public Color getLightgreen() { rgb(144, 238, 144) }
    public Color getLightgrey() { rgb(211, 211, 211) }
    public Color getLightpink() { rgb(255, 182, 193) }
    public Color getLightsalmon() { rgb(255, 160, 122) }
    public Color getLightseagreen() { rgb(32, 178, 170) }
    public Color getLightskyblue() { rgb(135, 206, 250) }
    public Color getLightslategray() { rgb(119, 136, 153) }
    public Color getLightsteelblue() { rgb(176, 196, 222) }
    public Color getLightyellow() { rgb(255, 255, 224) }
    public Color getLime() { rgb(0, 255, 0) }
    public Color getLimegreen() { rgb(50, 205, 50) }
    public Color getLinen() { rgb(250, 240, 230) }
    public Color getMagenta() { rgb(255, 0, 255) }
    public Color getMaroon() { rgb(128, 0, 0) }
    public Color getMediumaquamarine() { rgb(102, 205, 170) }
    public Color getMediumblue() { rgb(0, 0, 205) }
    public Color getMediumorchid() { rgb(186, 85, 211) }
    public Color getMediumpurple() { rgb(147, 112, 219) }
    public Color getMediumseagreen() { rgb(60, 179, 113) }
    public Color getMediumslateblue() { rgb(123, 104, 238) }
    public Color getMediumspringgreen() { rgb(0, 250, 154) }
    public Color getMediumturquoise() { rgb(72, 209, 204) }
    public Color getMediumvioletred() { rgb(199, 21, 133) }
    public Color getMidnightblue() { rgb(25, 25, 112) }
    public Color getMintcream() { rgb(245, 255, 250) }
    public Color getMistyrose() { rgb(255, 228, 225) }
    public Color getMoccasin() { rgb(255, 228, 181) }
    public Color getNavajowhite() { rgb(255, 222, 173) }
    public Color getNavy() { rgb(0, 0, 128) }
    public Color getOldlace() { rgb(253, 245, 230) }
    public Color getOlive() { rgb(128, 128, 0) }
    public Color getOlivedrab() { rgb(107, 142, 35) }
    public Color getOrange() { rgb(255, 165, 0) }
    public Color getOrangered() { rgb(255, 69, 0) }
    public Color getOrchid() { rgb(218, 112, 214) }
    public Color getPalegoldenrod() { rgb(238, 232, 170) }
    public Color getPalegreen() { rgb(152, 251, 152) }
    public Color getPaleturquoise() { rgb(175, 238, 238) }
    public Color getPalevioletred() { rgb(219, 112, 147) }
    public Color getPapayawhip() { rgb(255, 239, 213) }
    public Color getPeachpuff() { rgb(255, 218, 185) }
    public Color getPeru() { rgb(205, 133, 63) }
    public Color getPink() { rgb(255, 192, 203) }
    public Color getPlum() { rgb(221, 160, 221) }
    public Color getPowderblue() { rgb(176, 224, 230) }
    public Color getPurple() { rgb(128, 0, 128) }
    public Color getRed() { rgb(255, 0, 0) }
    public Color getRosybrown() { rgb(188, 143, 143) }
    public Color getRoyalblue() { rgb(65, 105, 225) }
    public Color getSaddlebrown() { rgb(139, 69, 19) }
    public Color getSalmon() { rgb(250, 128, 114) }
    public Color getSandybrown() { rgb(244, 164, 96) }
    public Color getSeagreen() { rgb(46, 139, 87) }
    public Color getSeashell() { rgb(255, 245, 238) }
    public Color getSienna() { rgb(160, 82, 45) }
    public Color getSilver() { rgb(192, 192, 192) }
    public Color getSkyblue() { rgb(135, 206, 235) }
    public Color getSlateblue() { rgb(106, 90, 205) }
    public Color getSlategray() { rgb(112, 128, 144) }
    public Color getSnow() { rgb(255, 250, 250) }
    public Color getSpringgreen() { rgb(0, 255, 127) }
    public Color getSteelblue() { rgb(70, 130, 180) }
    public Color getTan() { rgb(210, 180, 140) }
    public Color getTeal() { rgb(0, 128, 128) }
    public Color getThistle() { rgb(216, 191, 216) }

    public Color tomato(BigDecimal alpha) {
        return color(tomato, alpha)
    }
    
    public Color getTomato() { rgb(255, 99, 71) }
    public Color getTurquoise() { rgb(64, 224, 208) }
    public Color getViolet() { rgb(238, 130, 238) }
    public Color getWheat() { rgb(245, 222, 179) }
    public Color getWhite() { rgb(255, 255, 255) }
    public Color getWhitesmoke() { rgb(245, 245, 245) }
    public Color getYellow() { rgb(255, 255, 0) }
    public Color getYellowgreen() { rgb(154, 205, 50) }
}
