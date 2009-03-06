package loafers.text

import java.lang.StringBuilder
public class PlainFragment extends TextFragment {
	private String text
	
	public PlainFragment(String text) {
		this.text = text
	}
	
	/**
	 * Encodes the given text using html entities.
	 * <p>
	 * Letters, digits and whitespace is kept, all other characters are converted into a html entity as <code>&amp;#&lt;character as int&gt;;</code>
	 */
	public static String HTMLEntityEncode( String text ) {
		return text.toCharArray().inject("") { encoded, c ->
			if ( c.isWhitespace() || c.isLetterOrDigit() ) {
				encoded += c;
			}
			else {
				encoded += "&#" + (int)c + ";";
			}
		
			return encoded
		}
	}
	
	public String getHtmlFragment() {
		def matcher = (HTMLEntityEncode(text) =~ /\n/);
		return matcher.replaceAll("<br>");
	}
	
	public String getText() {
		return text
	}
	
	protected void doSetText(String text) {
		this.text = text
	}
}