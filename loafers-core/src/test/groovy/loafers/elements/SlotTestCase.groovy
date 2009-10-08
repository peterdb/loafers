package loafers.elements

import java.awt.event.MouseEvent;
import javax.swing.JButton
import groovy.util.GroovyTestCase
/**
 * Abstract testcase for testing Slot implementations
 */
public abstract class SlotTestCase extends GroovyTestCase {

    private Slot slot

    // various elements for testing
    private Button button
    private TextBlock textBlock
    private Check check

    protected final void setUp() throws Exception {
        slot = createSlot()

        // trigger component creation
        slot.component

        // create test elements
        button = new Button()
        textBlock = new TextBlock()
        check = new Check()
    }

    protected abstract Slot createSlot()

    public void testPreconditions() {
        assert slot != null

        assert button != null
        assert textBlock != null
        assert check != null
    }

    public void testClear() {
    	slot.append(textBlock)
    	slot.append(button)

    	assert [textBlock, button] == slot.contents
    	
    	slot.clear()
    	
    	assert [] == slot.contents
    	assert [] == slot.panel.components

        assert button.parent == null
        assert textBlock.parent == null
    }

    public void testAppend() {
        assert [] == slot.contents
        assert [] == slot.panel.components
        
        slot.append(button)
        assert [button] == slot.contents
        assert [button.component] == slot.panel.components
        
        slot.append(textBlock)
        assert [button, textBlock] == slot.contents
        assert [button.component, textBlock.component] == slot.panel.components
    }

    public void testPrepend() {
        assert [] == slot.contents
        assert [] == slot.panel.components
        
        slot.append(button)
        assert [button] == slot.contents
        assert [button.component] == slot.panel.components
        
        slot.prepend(textBlock)
        assert [textBlock, button] == slot.contents
        assert [textBlock.component, button.component] == slot.panel.components
    }

    public void testBefore() {
        assert [] == slot.contents
        assert [] == slot.panel.components
        
        slot.append(button)
        assert [button] == slot.contents
        assert [button.component] == slot.panel.components
        
        slot.before(button, textBlock)
        assert [textBlock, button] == slot.contents
        assert [textBlock.component, button.component] == slot.panel.components

        slot.before(button, check)
        assert [textBlock, check, button] == slot.contents
        assert [textBlock.component, check.component, button.component] == slot.panel.components
    }

    public void testAfter() {
        assert [] == slot.contents
        assert [] == slot.panel.components
        
        slot.append(button)
        assert [button] == slot.contents
        assert [button.component] == slot.panel.components
        
        slot.after(button, textBlock)
        assert [button, textBlock] == slot.contents
        assert [button.component, textBlock.component] == slot.panel.components

        slot.after(button, check)
        assert [button, check, textBlock] == slot.contents
        assert [button.component, check.component, textBlock.component] == slot.panel.components
    }

    public void testAppendWithClosure() {
        slot.append(button)
        
        def b
        
        slot.append {
            b = button("test")
        }

        assert [button, b] == slot.contents
        assert [button.component, b.component] == slot.panel.components
    }

    public void testPrependWithClosure() {
        slot.append(button)
        
        def b
        
        slot.prepend {
            b = button("test")
        }

        assert [b, button] == slot.contents
        assert [b.component, button.component] == slot.panel.components
    }

    public void testBeforeWithClosure() {
        slot.append(button)
        slot.append(textBlock)
        
        def b
        
        slot.before(textBlock) {
            b = button("test")
        }

        assert [button, b, textBlock] == slot.contents
        assert [button.component, b.component, textBlock.component] == slot.panel.components
    }

    public void testAfterWithClosure() {
        slot.append(button)
        slot.append(textBlock)
        
        def b
        
        slot.after(button) {
            b = button("test")
        }

        assert [button, b, textBlock] == slot.contents
        assert [button.component, b.component, textBlock.component] == slot.panel.components
    }

    public void testRemove() {
        slot.append(button)
        slot.append(check)
        slot.append(textBlock)
        
        assert button.parent == slot
        assert check.parent == slot
        assert textBlock.parent == slot

        assert [button, check, textBlock] == slot.contents
        assert [button.component, check.component, textBlock.component] == slot.panel.components

        slot.remove(check)
        assert [button, textBlock] == slot.contents
        assert [button.component, textBlock.component] == slot.panel.components

        slot.remove(button)
        assert [textBlock] == slot.contents
        assert [textBlock.component] == slot.panel.components

        slot.remove(textBlock)
        assert [] == slot.contents
        assert [] == slot.panel.components

        assert button.parent == null
        assert check.parent == null
        assert textBlock.parent == null
    }

    // TODO move all events related tests to a seperate test case

    public void testClickEvent() {
        slot.click {
            println "jup"
        }

        slot.panel.dispatchEvent new MouseEvent(slot.panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 10, 10, 1, false)
    }
}