package loafers.text

public class Em extends StyledFragment {
	public Em(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<em>${text}</em>"
	}
}