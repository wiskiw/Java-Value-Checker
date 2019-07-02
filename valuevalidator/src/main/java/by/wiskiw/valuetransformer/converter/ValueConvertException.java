package by.wiskiw.valuetransformer.converter;

/**
 * Ошибка преобразования типов в {@link ValueConverter}
 *
 * @author Andrey Yablonsky
 */
public class ValueConvertException extends IllegalArgumentException {

    private boolean isFatal = true;

    public ValueConvertException() {
    }

    public ValueConvertException(String s) {
        super(s);
    }

    public ValueConvertException(String s, boolean isFatal) {
        super(s);
        this.isFatal = isFatal;
    }

    public ValueConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public void setFatal(boolean fatal) {
        isFatal = fatal;
    }

    public boolean isFatal() {
        return isFatal;
    }
}
