package loafers.text

public class Sub extends StyledFragment {
	public Sub(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<sub>${text}</sub>"
	}
}