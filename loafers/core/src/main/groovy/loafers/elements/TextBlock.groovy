package loafers.elements

import javax.swing.event.HyperlinkListener
import javax.swing.event.HyperlinkEvent
import java.awt.Font
/**
 * A block of text, contains sequences of textclasses
 * has a size which defines the text size of the entire block
 * para, banner, ...
 */
// TODO use xhtmlrenderer for html rendering?
public class TextBlock extends ComponentElement {

	private static final Font FONT = UIManager.getFont("Label.font")
	
	private List contents = []

	protected JComponent createComponent() {
		JTextPane textPane = new JTextPane()
		textPane.contentType = "text/html"
		// set the initial text, otherwise preferred size is incorrect
		textPane.text = "<html><body>&nbsp</body></html>"
		
		// style the JTextPane as a JLabel
		textPane.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, true);
		textPane.font = FONT
		textPane.border = BorderFactory.createEmptyBorder()
		textPane.editable = false
		textPane.opaque = false
		textPane.highlighter = null

		// hyperlink listener
		textPane.addHyperlinkListener({evt -> 
			if(evt.eventType == HyperlinkEvent.EventType.ACTIVATED) {
				def link = contents.find { System.identityHashCode(it).toString() == evt.description }
				link?.click()
			}
		} as HyperlinkListener)
		
		return textPane
	}
    
    public JTextPane getTextPane() {
    	return component
    }
	
	public List contents() {
		return contents
	}
	
	public String getText() {
		return contents.inject('') { text, item -> text += item.text }.trim()
	}
	
	public setText(text) {
		style(['text': text])
	}
	
	public void style(Map styles) {
		super.style(styles)
		
		if (styles.text) {
			def text = styles.text
			
    		def fragments
    		if (text instanceof List) {
    			fragments = text
    		} else {
    			fragments = [text]
    		}

    		// transform plain text to a PlainFragment instance
        	fragments = fragments.collect{ it instanceof TextFragment ? it : new PlainFragment(it.toString()) }
			fragments.each({ it.block = this })

			contents = fragments
			
			update()
		}
		
		if (styles.size) {
			float defaultSize = 12f
	        float size = styles.size ? styles.size : defaultSize
	        float targetSize = FONT.size * size / defaultSize
	        
	        textPane.font = textPane.font.deriveFont(targetSize)
		}
		
		if (styles.stroke) {
			textPane.foreground = styles.stroke
		}
		
		if (styles.align) {
			update()
		}
	}
	
	public void update() {
		SwingUtilities.invokeLater({
			String html = "<html><body>"
			if(styles().kerning) {
				html += "<div style='letter-spacing: ${styles().kerning}'>"
			}
			if(styles().align) {
				html += "<div style='text-align: ${styles().align}'>"
			}
			contents.each({fragment -> html += fragment.htmlFragment})
			if(styles().align) {
				html += "</div>"
			}
			if(styles().kerning) {
				html += "</div>"
			}
			html += "</body></html>"
			
			textPane.text = html
		} as Runnable)
	}
}