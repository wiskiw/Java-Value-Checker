package by.wiskiw.fieldsvalidator.demo.validation;

/**
 * @author Andrey Yablonsky on 21.02.2020
 */
public class InputValidateException extends Exception {

    public InputValidateException() {
    }

    public InputValidateException(String message) {
        super(message);
    }

    public InputValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputValidateException(Throwable cause) {
        super(cause);
    }
}
