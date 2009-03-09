package loafers.elements

import javax.swing.JProgressBarimport javax.swing.JComponent
public class Progress extends ComponentElement {
	private float fraction
	
	protected JComponent createComponent() {
		return new JProgressBar(0, 100)
	}
	
	public JProgressBar getProgressBar() {
		return component
	}
	
	public void setFraction(float fraction) {
		this.fraction = fraction
		progressBar.value = (int)(fraction * 100)
	}
	
	public float getFraction() {
		return fraction
	}
}