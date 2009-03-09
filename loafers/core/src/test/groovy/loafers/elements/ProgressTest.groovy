package loafers.elements

import groovy.util.GroovyTestCaseimport javax.swing.JProgressBarimport javax.swing.JProgressBar
public class ProgressTest extends GroovyTestCase {
    
    public void testComponent() {
        Progress progress = new Progress()
        
        assert progress.component instanceof JProgressBar : "component is not a JProgressBar"
        assert progress.progressBar instanceof JProgressBar : "button is not a JProgressBar"
        assert progress.component == progress.progressBar : "component must be the same as the progress bar"
    }
    
    public void testFraction() {
    	Progress progress = new Progress()
        
    	assert progress.fraction == 0.0
    	assert progress.progressBar.value == 0
    	
    	progress.fraction = 0.5
    	
    	assert progress.fraction == 0.5
    	assert progress.progressBar.value == 50
    	
    	progress.fraction = 1.0
    	
    	assert progress.fraction == 1.0
    	assert progress.progressBar.value == 100
    }
}