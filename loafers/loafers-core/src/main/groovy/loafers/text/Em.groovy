package loafers.text

public class Em extends StyledFragment {
	public Em(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<em>${text}</em>"
	}
}