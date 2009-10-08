package loafers.text

public class Del extends StyledFragment {
	public Del(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<span style=\"text-decoration: line-through;\">${text}</span>"
	}
}