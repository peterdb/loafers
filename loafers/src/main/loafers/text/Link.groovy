package loafers.text

public class Link extends StyledFragment {
	private Closure click

	public Link(TextFragment inner, Closure click = null) {
		super(inner)
		this.click = click
	}

	public String doGetHtmlFragment(String text) {
		return "<a href='${System.identityHashCode(this)}'>${text}</a>"
	}
	
	public void click() {
		click.call()
	}
}