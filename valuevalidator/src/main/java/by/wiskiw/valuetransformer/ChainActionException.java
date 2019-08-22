package by.wiskiw.valuetransformer;

/**
 * Ошибка выполнения {@link ChainAction}
 *
 * @author Andrey Yablonsky
 */
public class ChainActionException extends IllegalArgumentException {

    public ChainActionException() {
    }

    public ChainActionException(String s) {
        super(s);
    }

    public ChainActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChainActionException(Throwable cause) {
        super(cause);
    }
}
