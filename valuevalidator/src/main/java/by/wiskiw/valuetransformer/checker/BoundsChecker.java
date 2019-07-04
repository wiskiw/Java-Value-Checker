package by.wiskiw.valuetransformer.checker;

import android.support.annotation.Nullable;

/**
 * {@link ChainCheckAction} для проверки принадлежность числа заданному диапазону.
 *
 * @author Andrey Yablonsky
 */
public final class BoundsChecker extends ChainCheckAction<Integer> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must be in [%d, %d] range!";

    private int minLength;
    private int maxLength;

    public BoundsChecker(int minLength, int maxLength) {
        super(DEFAULT_FAILED_MESSAGE);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public BoundsChecker(String customFailedMessage, int minLength, int maxLength) {
        super(customFailedMessage);

        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValueCorrect(Integer value) {
        return minLength <= value && value <= maxLength;
    }

    @Override
    protected String getFailedMessage(@Nullable String preferredMessageTemplate, Integer failedValue) {
        String template = preferredMessageTemplate != null ? preferredMessageTemplate : DEFAULT_FAILED_MESSAGE;
        return String.format(template, minLength, maxLength);
    }
}