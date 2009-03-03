package loafers.text

public class Ins extends StyledFragment {
	public Ins(TextFragment inner) {
		super(inner)
	}

	public String doGetHtmlFragment(String text) {
		return "<u>${text}</u>"
	}
}