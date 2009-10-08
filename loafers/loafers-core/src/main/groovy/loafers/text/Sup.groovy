package loafers.text

public class Sup extends StyledFragment {
	public Sup(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<sup>${text}</sup>"
	}
}