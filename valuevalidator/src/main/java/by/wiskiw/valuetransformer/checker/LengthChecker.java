package by.wiskiw.valuetransformer.checker;

/**
 * Реализация {@link ChainCheckAction} для проверки длинны строки.
 *
 * @author Andrey Yablonsky
 */
public class LengthChecker extends ChainCheckAction<String> {

    private static final String DEFAULT_FAILED_MESSAGE = "The length of string must be in [%d, %d] range!";
    private static final String ACCURATE_DEFAULT_FAILED_MESSAGE = "The string must be %d characters long!";

    private final RangeChecker<Integer> rangeChecker;

    public LengthChecker(int minLength, int maxLength, String customFormatMessage) {
        super(customFormatMessage);

        rangeChecker = new RangeChecker<>(minLength, maxLength, true, customFormatMessage);
    }

    public LengthChecker(int minLength, int maxLength) {
        this(minLength, maxLength, DEFAULT_FAILED_MESSAGE);
    }

    public LengthChecker(int accurateLength, String customFormatMessage) {
        this(accurateLength, accurateLength, customFormatMessage);
    }

    public LengthChecker(int accurateLength) {
        this(accurateLength, ACCURATE_DEFAULT_FAILED_MESSAGE);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return rangeChecker.isValueCorrect(value.length());
    }

    @Override
    protected String getFailedMessage(String messageTemplate, String failedValue) {
        return String.format(messageTemplate, rangeChecker.getMinValue(), rangeChecker.getMaxValue());
    }

}
