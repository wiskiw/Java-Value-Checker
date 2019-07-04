package by.wiskiw.valuetransformer.checker;

/**
 * {@link ChainCheckAction}, которые не допускает null значения.
 *
 * @author Andrey Yablonsky
 */
public final class NotNullChecker<T> extends ChainCheckAction<T> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must be null!";

    public NotNullChecker() {
        super(DEFAULT_FAILED_MESSAGE);
    }

    public NotNullChecker(String customFailedMessage) {
        super(customFailedMessage);
    }

    @Override
    public boolean isValueCorrect(T value) {
        return value != null;
    }

}
