package loafers.core;

import groovy.lang.Delegate;
import groovy.lang.Mixin;
import loafers.elements.Element;
import loafers.elements.Slot;
import loafers.elements.App;

/**
 * Delegate to be used by all Closures executed within the application.
 * <p>
 * This class aggregates all needed methods/properties. (colors, ...)
 * 
 * @author Peter De Bruycker
 */
public class LoafersClosureDelegate {

    @Delegate
    ArtMethods artMethods
    
    @Delegate
    ColorMethods colorMethods = new ColorMethods()

    @Delegate
    ClipboardMethods clipboardMethods = new ClipboardMethods()

    @Delegate
    DialogMethods dialogMethods = new DialogMethods()

    @Delegate 
    TimerMethods timerMethods = new TimerMethods()

    @Delegate
    TextMethods textMethods
    
    @Delegate
    ElementBuilderMethods elementBuilderMethods

    @Delegate
    Slot delegateSlot
    
    public LoafersClosureDelegate(Slot slot) {
        this(slot, null)
    }

    /**
     * The strategy defines how elements will be added to the Slot.
     */
    public LoafersClosureDelegate(Slot slot, Closure addStrategy) {
        assert slot != null

        // following methods classes need a slot to operate on
        artMethods = new ArtMethods(slot)
        textMethods = new TextMethods(slot, addStrategy)
        elementBuilderMethods = new ElementBuilderMethods(slot, addStrategy)
        
        delegateSlot = slot

        // trigger component creation
        slot.component
    }

    public void exit() {
        // TODO store the current app as an instance field of LoafersClosureDelegate
        App.currentApp.exit()
    }

    public List getMouse() {
        return App.currentApp.mouse
    }

}
