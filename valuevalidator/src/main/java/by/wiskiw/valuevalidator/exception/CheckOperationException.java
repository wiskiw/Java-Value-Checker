package by.wiskiw.valuevalidator.exception;

/**
 * @author Andrey Yablonsky
 */
public class CheckOperationException extends OperationException {

    public CheckOperationException() {
    }

    public CheckOperationException(String message) {
        super(message);
    }

    public CheckOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckOperationException(Throwable cause) {
        super(cause);
    }
}
