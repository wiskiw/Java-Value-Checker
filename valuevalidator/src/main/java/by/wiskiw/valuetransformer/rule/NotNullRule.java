package by.wiskiw.valuetransformer.rule;

/**
 * {@link RuleAction}, которые не допускает null значения.
 *
 * @author Andrey Yablonsky
 */
public final class NotNullRule<T> extends RuleAction<T> {

    private static final String DEFAULT_ERROR_MESSAGE = "Value must be null!";

    public NotNullRule(String messageTemplate) {
        super(messageTemplate);
    }

    public NotNullRule() {
        this(DEFAULT_ERROR_MESSAGE);
    }

    @Override
    public boolean isValueCorrect(T value) {
        return value != null;
    }

}
