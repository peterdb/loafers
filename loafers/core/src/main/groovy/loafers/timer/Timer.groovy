package loafers.timer

import java.util.TimerTask

// TODO handle pause
public class Timer extends BaseTimer {
	private long delay

	public Timer(long delay) {
		this.delay = delay
	}

	protected void doStart(java.util.Timer timer, Closure trigger) {
		timer.schedule( {
			trigger()
		} as TimerTask, delay*1000)
	}
}