package loafers.core.support;

import groovy.lang.Closure;
import loafers.elements.Element;
import loafers.elements.Slot;

/**
 * @author Peter De Bruycker
 */
public abstract class SlotMethodsSupport {

    private Slot slot
    private Closure addStrategy

    public SlotMethodsSupport(Slot slot, Closure addStrategy) {
        assert slot != null

        this.slot = slot
        this.addStrategy = addStrategy
    }
    
    public Slot getSlot() {
        return slot
    }

    public Closure getAddStrategy() {
        return addStrategy;
    }

    // TODO test to see if the manipulation methods are still necessary here, because the LoafersClosureDelegate also delegates to the slot itself
    // this means that we can only keep the element creation methods
    public void prepend(Element target, Closure closure) {
        slot.prepend(closure)
    }

    public void before(Element target, Closure closure) {
        slot.before(target, closure)
    }

    public void after(Element target, Closure closure) {
        slot.after(target, closure)
    }

    public void append(Element target, Closure closure) {
        slot.append(closure)
    }

    protected void addElement(Element e) {
        assert e != null

        if(addStrategy == null) {
            slot.append(e)
        } else {
            addStrategy(e)
        }
    }
}
