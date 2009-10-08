package loafers.elements;

import java.util.Map;

import javax.swing.JFrame
public class App extends Window {
    private static App currentApp
    
	private Window window

    private Map properties = [:]
	
	public App() {
    	frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    	currentApp = this
	}
	
	public void exit() {
		close()
	}

    public Object propertyMissing(String name) {
        return properties[name]
    }

    public void propertyMissing(String name, value) {
        properties[name] = value 
    }
	
	public static App getCurrentApp() {
	    return currentApp
	}
}
