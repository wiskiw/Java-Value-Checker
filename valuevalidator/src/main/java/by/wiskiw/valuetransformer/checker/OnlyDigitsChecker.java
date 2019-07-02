package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ValueChecker;

/**
 * Допускает наличие только цифр в строке
 *
 * @author Andrey Yablonsky
 */
public class OnlyDigitsChecker extends ValueChecker<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must to consist of digits only!";
    private static final String DIGITS_REGEXP = "-?\\d+(\\.\\d+)?";

    public OnlyDigitsChecker() {
    }

    public OnlyDigitsChecker(String customFormatMessage) {
        super(customFormatMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return value.matches(DIGITS_REGEXP);
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }
}
