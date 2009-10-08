package loafers;


/**
 * Testcase for TimerMethods
 * 
 * @author Peter De Bruycker
 */
public class TimerMethodsTest extends GroovyTestCase {

    private TimerMethods timerMethods
    
    @Override
    protected void setUp() throws Exception {
        timerMethods = new TimerMethods()
    }

    public void testPreconditions() {
        assert timerMethods != null
    }
    
    public void testTimer() {
        String msg = ""
        long before = System.currentTimeMillis()
        long after = 0
        boolean done = false
        
        timerMethods.timer(2, { 
            after = System.currentTimeMillis(); 
            done = true 
        })

        while (!done) {
            sleep 100
        }

        println after - before
    }
    
}
