package loafers.core;

import groovy.lang.Closure;

import java.util.Map;

import loafers.core.support.SlotMethodsSupport;
import loafers.elements.Slot;
import loafers.elements.TextBlock;
import loafers.text.Code;
import loafers.text.Del;
import loafers.text.Em;
import loafers.text.Link;
import loafers.text.Strong;
import loafers.text.PlainFragment;
import loafers.text.CompositeFragment;
import loafers.text.TextFragment;


/**
 * All methods for all kinds of text.
 * 
 * @author Peter De Bruycker
 */
public class TextMethods extends SlotMethodsSupport {
    
    public TextMethods(Slot slot, Closure addStrategy = null) {
        super(slot, addStrategy)
    }

    public TextBlock banner(Object...content = []) {
        return banner([:], content)
    }
    
    public TextBlock banner(Map styles, Object...content = []) {
        return textBlock(content, styles, 48)
    }

    public TextBlock title(Object...content = []) {
        return title([:], content)
    }
    
    public TextBlock title(Map styles, Object...content = []) {
        return textBlock(content, styles, 34)
    }

    public TextBlock subtitle(Object...content = []) {
        return subtitle([:], content)
    }
    
    public TextBlock subtitle(Map styles, Object...content = []) {
        return textBlock(content, styles, 26)
    }

    public TextBlock tagline(Object...content = []) {
        return tagline([:], content)
    }
    
    public TextBlock tagline(Map styles, Object...content = []) {
        return textBlock(content, styles, 18)
    }

    public TextBlock caption(Object...content = []) {
        return caption([:], content)
    }
    
    public TextBlock caption(Map styles, Object...content = []) {
        return textBlock(content, styles, 14)
    }

    public TextBlock para(Object...fragments = []) {
        return para([:], fragments)
    }
    
    public TextBlock para(Map styles, Object...fragments = []) {
        return textBlock(fragments, styles, 12)
    }

    public TextBlock inscription(Object...content = []) {
        return inscription([:], content)
    }
    
    public TextBlock inscription(Map styles, Object...content = []) {
        return textBlock(content, styles, 10)
    }

    private TextBlock textBlock(Object... fragments, Map styles, int size) {
        TextBlock textBlock = new TextBlock()

        if (fragments != null) {
            styles.text = createTextFragment(fragments)
        }
        
        if (!styles.size) {
            styles.size = size
        }

        textBlock.style(styles)
        
        addElement(textBlock)
        
        return textBlock
    }

    private TextFragment createTextFragment(Object... fragments) {
        if(fragments.size() == 1) {
            if(fragments[0] instanceof TextFragment)  {
                return fragments[0]
            }else {
                return new PlainFragment(fragments[0])
            }
        }
        
        return new CompositeFragment(fragments.collect{ it ->
            if(it instanceof TextFragment) {
                return it
            } else {
                return new PlainFragment(it.toString())
            }
        })
    }

    public Strong strong(Object... fragments) {
        return new Strong(createTextFragment(fragments))
    }

    public Code code(Object... fragments) {
        return new Code(createTextFragment(fragments))
    }

    public Em em(Object... fragments) {
        return new Em(createTextFragment(fragments))
    }

    public Del del(Object... fragments) {
        return new Del(createTextFragment(fragments))
    }

    public Link link(Object fragment, Closure click = null) {
        return new Link(createTextFragment(fragment), click)
    }
    
    public Link link(Object... fragments, Closure click = null) {
        return new Link(createTextFragment(fragments), click)
    }
}
