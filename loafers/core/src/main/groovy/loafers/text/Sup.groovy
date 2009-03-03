package loafers.text

public class Sup extends StyledFragment {
	public Sup(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<sup>${text}</sup>"
	}
}