package loafers.core;

import loafers.elements.Slot

import loafers.paint.Color;
import loafers.paint.Pattern

import loafers.art.*

/**
 * @author Peter De Bruycker
 */
public class ArtMethods {

    private Slot slot
    
    private Pattern fill
    private Pattern stroke
    private Integer strokeWidth

    // transformations
    private boolean transformAtCorner = true
    private Double rotation
    private List translation

    public ArtMethods(Slot slot) {
        assert slot != null
        
        this.slot = slot
    }
    
    public void getNofill() {
        fill((Pattern)null)
    }

    public void fill(String fill) {
        // TODO can either be an image or a html color sequence
    }

    public void fill(java.awt.Color color) {
        fill(color == null ? null : new Color(color))
    }

    public void fill(Pattern fill) {
        // TODO return the pattern?
        
        this.fill = fill
    }

    public void getNostroke() {
        stroke(null)
    }

    public void stroke(String stroke) {
        // TODO can either be an image or a html color sequence
    }

    public void stroke(java.awt.Color color) {
        stroke(color == null ? null : new Color(color))
    }

    public void stroke(Pattern stroke) {
        this.stroke = stroke
    }

    public void strokewidth(int strokeWidth) {
        this.strokeWidth = strokeWidth
    }

    public void rotate(double degrees) {
        rotation = degrees
    }

    public void translate(int left, int top) {
        translation = [left, top]
    }

    public void transform(String transform) {
        assert transform in ["corner", "center"], "Transform must either be corner or center"
        
        transformAtCorner = transform == "corner"
    }

    public AbstractShape star(int left, int top, int points = 10, double outer = 100.0, double inner = 50.0) {
        return null;
    }

    public AbstractShape arc(int left, int top, int width, int height, double angle1, double angle2) {
        return null;
    }

    public AbstractShape arrow(int left, int top, int width) {
        return null;
    }

    public AbstractShape line(int left, int top, int x2, int y2) {
        return null;
    }

    public Oval oval(int left, int top, int radius) {
        return oval(['left':left, 'top':top, 'radius':radius])
    }

    public Oval oval(Map styles) {
        assert styles != null, "styles cannot be null"
        
        Oval oval = new Oval()

        oval.fill = fill
        oval.stroke = stroke
        oval.strokeWidth = strokeWidth

        oval.transformAtCorner = transformAtCorner
        oval.rotation = rotation
        oval.translation = translation
        
        slot.addShape(oval)
        
        oval.style(styles)
        
        return oval;
    }

    public Rect rect(int left, int top, int width, int height) {
        return rect(['left':left, 'top':top, 'width':width, 'height':height])
    }

    public Rect rect(Map styles) {
        assert styles != null, "styles cannot be null"
        
        Rect rect = new Rect()

        rect.fill = fill
        rect.stroke = stroke
        rect.strokeWidth = strokeWidth

        rect.transformAtCorner = transformAtCorner
        rect.rotation = rotation
        rect.translation = translation
        
        slot.addShape(rect)
        
        rect.style(styles)
        
        return rect;
    }
}
