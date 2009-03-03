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
	
	public String getText() {
		return inner.text
	}
	
	protected void doSetText(String text) {
		inner.text = text
	}
	
	public void setBlock(TextBlock block) {
		super.setBlock(block)
		inner.setBlock(block)
	}
	
	public String getHtmlFragment() {
		return doGetHtmlFragment(inner.getHtmlFragment())
	}
	
	protected abstract String doGetHtmlFragment(String text);
}