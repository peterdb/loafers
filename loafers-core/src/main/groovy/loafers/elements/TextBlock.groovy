package loafers.elements

import javax.swing.event.HyperlinkListener
import javax.swing.event.HyperlinkEvent
import javax.swing.event.HyperlinkEvent.EventType;
import java.awt.Fontimport javax.swing.UIManagerimport javax.swing.JEditorPaneimport javax.swing.BorderFactoryimport javax.swing.JTextPaneimport java.awt.Color
import loafers.text.CompositeFragment;

import loafers.ColorMethods;
import loafers.text.Link;
import loafers.text.PlainFragmentimport loafers.text.TextFragmentimport javax.swing.SwingUtilitiesimport java.lang.Runnableimport java.util.Map;

import javax.swing.JComponentimport java.awt.Dimension
/**
 * A block of text, contains sequences of textclasses
 * has a size which defines the text size of the entire block
 * para, banner, ...
 */
// TODO use xhtmlrenderer for html rendering?
public class TextBlock extends ComponentElement {

	private static final Font LABEL_FONT = UIManager.getFont("Label.font")
	
	private List fragments = []

	private JTextPane textPane
	
	public JComponent createComponent() {
		textPane = new JTextPane()
		
		// use html for text rendering
		textPane.contentType = "text/html"
		
		// set the initial text, otherwise preferred size is incorrect
		textPane.text = "<html><body>&nbsp</body></html>"
		
		// style the JTextPane as a JLabel
		textPane.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, true);
		textPane.font = LABEL_FONT
		textPane.border = BorderFactory.createEmptyBorder()
		textPane.editable = false
		textPane.opaque = false
		textPane.highlighter = null

		// hyperlink listener
		textPane.addHyperlinkListener({evt -> 
			if(evt.eventType == EventType.ACTIVATED) {
				Link link = findLink(fragments, evt.description)

				assert link != null, "link not found"
				
				link.click()
			}
		} as HyperlinkListener)
		
		return textPane
	}

	private Link findLink(List fragments, String id) {
        for (TextFragment fragment : fragments) {
            if(fragment instanceof Link && System.identityHashCode(fragment).toString() == id){
                return fragment
            }

            if(fragment instanceof CompositeFragment) {
                def result = findLink(fragment.fragments, id)

                if(result != null) {
                    return result
                }
            }
        }
	    
	    return null
	}
    
    public JTextPane getTextPane() {
    	return textPane
    }
	
	public List contents() {
		return fragments
	}
	
	public String getText() {
		return fragments.inject('') { text, item -> text += item.text }.trim()
	}
	
	public void setText(String text) {
		style(['text': text])
	}

	public void replace(String text) {
	    this.text = text;
	}

	protected void doStyle(Map styles) {
	    super.doStyle(styles)
	    
		if (styles.containsKey('text')) {
			def text = styles.text

    		def fragments
    		if (text == null) {
    		    fragments = []
    		} else if (text instanceof List) {
                fragments = text
            } else {
                fragments = [text]
    		}

    		// transform plain text to a PlainFragment instance
        	fragments = fragments.collect{ it instanceof TextFragment ? it : new PlainFragment(it.toString()) }
			fragments.each({ it.textBlock = this })

			this.fragments = fragments
			
			update()
		}

	    if (styles.containsKey('font')) {
	        if (styles.font == null) {
	            // default font
	            textPane.font = LABEL_FONT
	        } else {
	            textPane.font = new Font(styles.font, textPane.font.style, textPane.font.size)
	        }
	    }
		
		if (styles.containsKey('size')) {
			float defaultSize = 12f
	        float size = styles.size ? styles.size : defaultSize
	        float targetSize = LABEL_FONT.size * size / defaultSize
	        
	        textPane.font = textPane.font.deriveFont(targetSize)
		}
		
		if (styles.containsKey('stroke')) {
		    if(styles.stroke instanceof String) {
                textPane.foreground = new ColorMethods().fromString(styles.stroke)
		    } else {
	            textPane.foreground = styles.stroke
		    }
		}
		
		if (styles.align) {
			update()
		}
	}
	
	public void update() {
		String html = "<html><body>"
		if(styles.kerning) {
			html += "<div style='letter-spacing: ${styles.kerning}'>"
		}
		if(styles.align) {
			html += "<div style='text-align: ${styles.align}'>"
		}
		fragments.each({fragment -> html += fragment.htmlFragment})
		if(styles.align) {
			html += "</div>"
		}
		if(styles.kerning) {
			html += "</div>"
		}
		html += "</body></html>"

		textPane.text = html
	}
}