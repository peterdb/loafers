package loafers.text

public class Code extends StyledFragment {
	public Code(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<code>${text}</code>"
	}
}