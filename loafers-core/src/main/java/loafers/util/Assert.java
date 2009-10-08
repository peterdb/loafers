package loafers.util;

/**
 * @author Peter De Bruycker
 */
public class Assert {

    private Assert() {

    }

    public static void notNull(Object o, String msg) {
        isTrue(o != null, msg);
    }

    public static void isFalse(boolean bool, String msg) {
        isTrue(!bool, msg);
    }

    public static void isTrue(boolean bool, String msg) {
        if (!bool) {
            throw new IllegalArgumentException(msg);
        }
    }
}
