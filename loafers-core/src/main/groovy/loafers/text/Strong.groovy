package loafers.text

/**
 * Strong text
 *
 * @author Peter De Bruycker
 */
public class Strong extends StyledFragment {
	public Strong(TextFragment inner) {
		super(inner)
	}

	public String getStyledHtmlFragment(String text) {
		return "<strong>${text}</strong>"
	}

	@Override
	public String toString() {
	    return "Strong[$inner]";
	}
}