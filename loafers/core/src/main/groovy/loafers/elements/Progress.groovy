package loafers.elements

import javax.swing.JProgressBarimport javax.swing.SwingUtilitiesimport java.lang.Runnableimport javax.swing.JComponent
public class Progress extends ComponentElement {
	private float fraction
	
	protected JComponent createComponent() {
		return new JProgressBar(0, 100)
	}
	
	public JProgressBar getProgressBar() {
		return new JProgressBar()
	}
	
	public void setFraction(float fraction) {
		this.fraction = fraction
		SwingUtilities.invokeLater({
			progressBar.value = (int)(fraction * 100)
		} as Runnable)
	}
	
	public float getFraction() {
		return fraction
	}
}