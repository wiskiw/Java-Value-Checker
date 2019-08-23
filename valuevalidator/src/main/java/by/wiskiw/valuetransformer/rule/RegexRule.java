package by.wiskiw.valuetransformer.rule;

import java.util.regex.Pattern;

/**
 * Checker for test if value matches regular expression.
 *
 * @author Andrey Yablonsky
 */
public class RegexRule extends RuleAction<String> {

    private static final String DEFAULT_ERROR_MESSAGE = "Value '%s' does't pass '%s' regex expression!";

    private final String regexTemplate;

    /**
     * Main constructor.
     * @param regexTemplate regex mask for check.
     * @param messageTemplate failed message template. Receive failed value and regex as arguments.
     */
    public RegexRule(String regexTemplate, String messageTemplate) {
        super(messageTemplate);
        this.regexTemplate = regexTemplate;
    }

    /**
     * Additional constructor. Use default failed message template.
     * @param regexTemplate see {@link #RegexRule(String, String)}
     */
    public RegexRule(String regexTemplate) {
        this(regexTemplate, DEFAULT_ERROR_MESSAGE);
    }

    @Override
    public final boolean isValueCorrect(String value) {
        return Pattern.matches(regexTemplate, value);
    }

    @Override
    protected String getFailedMessage(String messageFormat, String failedValue) {
        return String.format(messageFormat, failedValue, regexTemplate);
    }
}
