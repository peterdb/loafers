package loafers.text

import loafers.elements.TextBlock

/**
 * a specific type of text (strong, code, link, ...)
 */
public abstract class StyledFragment extends TextFragment {
	private TextFragment inner

	public StyledFragment(TextFragment inner) {
		this.inner = inner;
	}

	protected TextFragment getInner() {
	    return inner
	}
	
	public String getText() {
		return inner.text
	}
	
	protected void doSetText(String text) {
		inner.text = text
	}
	
	public void setTextBlock(TextBlock block) {
		super.setTextBlock(block)
		
		inner.textBlock = block
	}
	
	public String getHtmlFragment() {
		return getStyledHtmlFragment(inner.getHtmlFragment())
	}
	
	protected abstract String getStyledHtmlFragment(String text);
}