package by.wiskiw.valuetransformer.utils;

/**
 * Utils class
 */
public class Utils {

    public static <T> void checkNotNull(T value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

}
