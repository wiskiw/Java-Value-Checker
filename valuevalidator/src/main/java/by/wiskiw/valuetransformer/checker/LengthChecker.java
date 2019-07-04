package by.wiskiw.valuetransformer.checker;

import android.support.annotation.Nullable;

/**
 * {@link ChainCheckAction} для проверки длинны строки.
 *
 * @author Andrey Yablonsky
 */
public class LengthChecker extends ChainCheckAction<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "The length of string must be in [%d, %d] range!";

    private int minLength;
    private int maxLength;

    public LengthChecker(int minLength, int maxLength) {
        super(DEFAULT_FAILED_MESSAGE);
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
    protected String getFailedMessage(@Nullable String messageTemplate, String failedValue) {
        String template = messageTemplate != null ? messageTemplate : DEFAULT_FAILED_MESSAGE;
        return String.format(template, minLength, maxLength);
    }

}
