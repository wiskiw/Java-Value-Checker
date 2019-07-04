package by.wiskiw.valuetransformer.checker;

/**
 * {@link ChainCheckAction} для проверки строки на пустоту.
 * Не допускает пустую строку или строку с whitespace символами.
 *
 * @author Andrey Yablonsky
 */
public class NotEmptyChecker extends ChainCheckAction<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "The string must not be empty!";

    public NotEmptyChecker() {
        super(DEFAULT_FAILED_MESSAGE);
    }

    public NotEmptyChecker(String customFailedMessage) {
        super(customFailedMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }

}
