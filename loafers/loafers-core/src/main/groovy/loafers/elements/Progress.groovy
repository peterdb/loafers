package loafers.elements

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JProgressBar;

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

    protected void doStyle(Map styles) {
        super.doStyle(styles)
    }
}