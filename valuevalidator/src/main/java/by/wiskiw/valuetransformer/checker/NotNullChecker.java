package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ValueChecker;

/**
 * Не допускает null значение
 *
 * @author Andrey Yablonsky
 */
public class NotNullChecker<T extends Object> extends ValueChecker<T> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must be null!";

    public NotNullChecker() {
    }

    public NotNullChecker(String customFailedMessage) {
        super(customFailedMessage);
        init();
    }

    private void init() {
        setFatal(true);
    }

    @Override
    public boolean isValueCorrect(T value) {
        return value != null;
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }

}
