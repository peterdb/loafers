package loafers.timer;

import java.util.Timer

public abstract class BaseTimer {
	private Closure trigger
	private Timer timer
	private boolean paused

	public void setTrigger(Closure c) {
		trigger = c
	}

	public void start() {
		timer = new Timer()
		doStart(timer, trigger)
	}
	
	protected abstract void doStart(Timer timer, Closure trigger);
	
	protected boolean isPaused() {
		return paused
	} 
	
	public void stop() {
		timer?.cancel()
		timer = null
	}
	
	public void toggle() {
		paused = !paused
	}
}
