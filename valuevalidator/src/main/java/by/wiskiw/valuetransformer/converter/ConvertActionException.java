package by.wiskiw.valuetransformer.converter;

/**
 * Thrown when {@link ConvertAction} cannot convert value.
 *
 * @author Andrey Yablonsky
 */
public class ConvertActionException extends Exception {

    public ConvertActionException() {
    }

    public ConvertActionException(String message) {
        super(message);
    }

    public ConvertActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertActionException(Throwable cause) {
        super(cause);
    }
}
