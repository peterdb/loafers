package loafers.timer

import java.util.Timer
import java.util.TimerTask


public class Every extends BaseTimer {
	private int seconds
	private int count = 1

	public Every(int seconds) {
		this.seconds = seconds
	}
	
	protected void doStart(Timer timer, Closure trigger) {
		timer.schedule( {
			if(!isPaused()) {
				trigger(count)
				count++
			}
		} as TimerTask, 0L, count*1000)
	}
}