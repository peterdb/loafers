package loafers.text

public class Ins extends StyledFragment {
	public Ins(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<u>${text}</u>"
	}
}