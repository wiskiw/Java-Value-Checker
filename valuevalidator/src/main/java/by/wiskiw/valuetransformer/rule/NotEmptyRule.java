package by.wiskiw.valuetransformer.rule;

/**
 * {@link RuleAction} для проверки строки на пустоту.
 * Не допускает пустую строку или строку с whitespace символами.
 *
 * @author Andrey Yablonsky
 */
public class NotEmptyRule extends RuleAction<String> {

    private static final String DEFAULT_ERROR_MESSAGE = "The string must not be empty!";

    public NotEmptyRule(String messageTemplate) {
        super(messageTemplate);
    }

    public NotEmptyRule() {
        this(DEFAULT_ERROR_MESSAGE);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }

}
