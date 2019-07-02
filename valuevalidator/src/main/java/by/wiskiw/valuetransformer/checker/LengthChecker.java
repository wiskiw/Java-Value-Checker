package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ValueChecker;

/**
 * Проверяет длину строки
 *
 * @author Andrey Yablonsky
 */
public class LengthChecker extends ValueChecker<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "The length of string must be in [%d, %d] range!";

    private int minLength;
    private int maxLength;

    public LengthChecker(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public LengthChecker(String customFormatMessage, int minLength, int maxLength) {
        super(customFormatMessage);

        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValueCorrect(String value) {

        int len = value.length();
        return minLength <= len && len <= maxLength;
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }

    @Override
    protected String createFailedMessage(String failedValue) {
        String customFailedMessage = getCustomFailedMessage();
        String failedMessageFormat = customFailedMessage != null ? customFailedMessage : getDefaultFailedMessage();

        return String.format(failedMessageFormat, minLength, maxLength);
    }

}
