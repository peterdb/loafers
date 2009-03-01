package loafers.text

public class Strong extends StyledFragment {
	public Strong(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<strong>${text}</strong>"
	}
}