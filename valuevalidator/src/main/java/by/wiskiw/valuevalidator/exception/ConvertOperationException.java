package by.wiskiw.valuevalidator.exception;

/**
 * @author Andrey Yablonsky
 */
public class ConvertOperationException extends OperationException {

    public ConvertOperationException() {
    }

    public ConvertOperationException(String message) {
        super(message);
    }

    public ConvertOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertOperationException(Throwable cause) {
        super(cause);
    }
}
