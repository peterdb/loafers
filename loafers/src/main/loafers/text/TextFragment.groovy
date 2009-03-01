package loafers.text;

import loafers.elements.TextBlock

public abstract class TextFragment {
	private TextBlock block

	public abstract String getText()
	
	public void setText(String text) {
		doSetText(text)
		block.update()
	}
	
	protected abstract void doSetText(String text)
	
	public abstract String getHtmlFragment()
	
	public void setBlock(TextBlock block) {
		this.block = block
	}
}
