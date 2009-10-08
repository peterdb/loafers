package loafers;

import loafers.timer.Every;
import loafers.timer.Animation;
import loafers.timer.Timer;

/**
 * Various methods for working with timers
 * 
 * @author Peter De Bruycker
 */
public class TimerMethods {

    public Every every(int seconds, Closure trigger) {
        assert trigger != null, "trigger cannot be null"
        
        Every every = new Every(seconds)

        every.trigger = trigger

        every.start()

        return every
    }

    public Timer timer(int seconds, Closure trigger) {
        assert trigger != null, "trigger cannot be null"
        
        Timer timer = new Timer(seconds)

        timer.trigger = trigger

        timer.start()

        return timer
    }

    public Animation animate(int fps, Closure trigger) {
        assert trigger != null, "trigger cannot be null"
        
        Animation animation = new Animation(fps)

        animation.trigger = trigger

        animation.start()

        return animation
    }
}
