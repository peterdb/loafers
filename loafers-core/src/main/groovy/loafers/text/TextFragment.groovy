package loafers.text;

import loafers.elements.TextBlock


public abstract class TextFragment {
    // parent text block
	TextBlock textBlock

	public abstract String getText()
	
	public void setText(String text) {
		doSetText(text)
		textBlock?.update()
	}
	
	protected abstract void doSetText(String text)
	
	public abstract String getHtmlFragment()
}
