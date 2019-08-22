package by.wiskiw.valuetransformer.rule;

/**
 * Реализация {@link RuleAction} для проверки длинны строки.
 *
 * @author Andrey Yablonsky
 */
public class LengthRule extends RuleAction<String> {

    private static final String DEFAULT_ERROR_MESSAGE = "The length of string must be in [%d, %d] range!";
    private static final String DEFAULT_ACCURATE_ERROR_MESSAGE = "The string must be %d characters long!";

    private final RangeRule<Integer> rangeRule;

    public LengthRule(int minLength, int maxLength, String customFormatMessage) {
        super(customFormatMessage);

        rangeRule = new RangeRule<>(minLength, maxLength, true, customFormatMessage);
    }

    public LengthRule(int minLength, int maxLength) {
        this(minLength, maxLength, DEFAULT_ERROR_MESSAGE);
    }

    public LengthRule(int accurateLength, String customFormatMessage) {
        this(accurateLength, accurateLength, customFormatMessage);
    }

    public LengthRule(int accurateLength) {
        this(accurateLength, DEFAULT_ACCURATE_ERROR_MESSAGE);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return rangeRule.isValueCorrect(value.length());
    }

    @Override
    protected String getFailedMessage(String messageFormat, String failedValue) {
        return String.format(messageFormat, rangeRule.getMinValue(), rangeRule.getMaxValue());
    }

}
