package loafers.core;

import groovy.lang.Delegate;
import groovy.lang.Mixin;
import loafers.builder.ElementsBuilder;
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
    ElementsBuilder elementsBuilder = new ElementsBuilder()

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

        artMethods = new ArtMethods(slot)
        
        delegateSlot = slot
        this.slot = slot

        // trigger component creation
        slot.component
        
        this.addStrategy = addStrategy
    }

    public void exit() {
        // TODO store the current app as an instance field of LoafersClosureDelegate
        App.currentApp.exit()
    }

    public List getMouse() {
        return App.currentApp.mouse
    }

}
