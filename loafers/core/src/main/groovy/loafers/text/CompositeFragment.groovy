package loafers.text;

import java.lang.StringBuilder
public class CompositeFragment extends TextFragment {

	private List fragments
	
	public CompositeFragment(List fragments) {
		this.fragments = fragments
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
}
