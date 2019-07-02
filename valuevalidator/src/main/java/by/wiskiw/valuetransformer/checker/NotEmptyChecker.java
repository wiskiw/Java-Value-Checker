package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ValueChecker;

/**
 * Не допускает пустую строку или строку с whitespace символами
 *
 * @author Andrey Yablonsky
 */
public class NotEmptyChecker extends ValueChecker<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "String value must not be empty!";

    public NotEmptyChecker() {
    }

    public NotEmptyChecker(String customFailedMessage) {
        super(customFailedMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }
}
