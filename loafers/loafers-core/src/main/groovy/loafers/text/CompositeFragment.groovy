package loafers.text;

import loafers.elements.TextBlock

/**
 * TextFragment that is composed of other TextFragments
 */public class CompositeFragment extends TextFragment {

	private List fragments
	
	public CompositeFragment(List fragments) {
		this.fragments = fragments
	}

	public List getFragments() {
	    return fragments
	}
	
	protected void doSetText(String text) {
		fragments = [new PlainFragment(text)]
	}

	public String getHtmlFragment() {
		StringBuilder buf = new StringBuilder()
		
		fragments.each( { buf.append(it.htmlFragment) } )
		
		return buf.toString();
	}

	public String getText() {
		StringBuilder buf = new StringBuilder()
		
		fragments.each( { buf.append(it.text) } )
		
		return buf.toString();
	}

	public void setTextBlock(TextBlock block) {
	    super.setTextBlock(block)

	    fragments.each { it.textBlock = block }
	}
}
