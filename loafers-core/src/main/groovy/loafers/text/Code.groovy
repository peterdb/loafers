package loafers.text

public class Code extends StyledFragment {
	public Code(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<code>${text}</code>"
	}
}