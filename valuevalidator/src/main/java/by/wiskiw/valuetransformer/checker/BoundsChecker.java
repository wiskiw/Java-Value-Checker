package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ValueChecker;

/**
 * Проверяет принадлежность числа заданному диапазону
 *
 * @author Andrey Yablonsky
 */
public class BoundsChecker extends ValueChecker<Integer> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must be in [%d, %d] range!";

    private int minLength;
    private int maxLength;

    public BoundsChecker(int minLength, int maxLength) {
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
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }

    @Override
    protected String createFailedMessage(Integer failedValue) {
        String customFailedMessage = getCustomFailedMessage();
        String failedMessageFormat = customFailedMessage != null ? customFailedMessage : getDefaultFailedMessage();

        return String.format(failedMessageFormat, minLength, maxLength);
    }
}