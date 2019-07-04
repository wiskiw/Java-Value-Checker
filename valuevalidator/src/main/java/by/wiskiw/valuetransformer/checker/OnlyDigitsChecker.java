package by.wiskiw.valuetransformer.checker;

/**
 * {@link ChainCheckAction} для проверки на наличие в строке только цифровых символов.
 *
 * @author Andrey Yablonsky
 */
public final class OnlyDigitsChecker extends ChainCheckAction<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must to consist of digits only!";

    private static final String DIGITS_REGEXP = "-?\\d+(\\.\\d+)?";

    public OnlyDigitsChecker() {
        super(DEFAULT_FAILED_MESSAGE);
    }

    public OnlyDigitsChecker(String customFormatMessage) {
        super(customFormatMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return value.matches(DIGITS_REGEXP);
    }
}
