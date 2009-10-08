package loafers.timer

import java.util.Timer
import java.util.TimerTask

import javax.swing.SwingUtilities;


public class Animation extends BaseTimer {
	private int fps
	private int frame = 1

	public Animation(int fps) {
		this.fps = fps
	}
	
	protected void doStart(Timer timer, Closure trigger) {
		timer.schedule( {
			if(!isPaused()) {
			    SwingUtilities.invokeLater({
	                trigger(frame)
			    } as Runnable)
				frame++
			}
		} as TimerTask, 0L, (long)(1000/fps))
	}
}