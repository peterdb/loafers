package loafers.text

public class Del extends StyledFragment {
	public Del(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<del>${text}</del>"
	}
}