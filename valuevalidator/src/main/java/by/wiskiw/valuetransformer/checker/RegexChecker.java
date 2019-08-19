package by.wiskiw.valuetransformer.checker;

import java.util.regex.Pattern;

/**
 * Checker for test if value matches regular expression.
 *
 * @author Andrey Yablonsky
 */
public class RegexChecker extends ChainCheckAction<String> {

    private static final String DEFAULT_FAILED_MESSAGE_FORMAT = "Value '%s' does't pass '%s' regex expression!";

    private final String regexTemplate;

    /**
     * Main constructor.
     * @param preferredMessageTemplate failed message template. Receive failed value and regex as arguments.
     * @param regexTemplate regex mask for check.
     */
    public RegexChecker(String preferredMessageTemplate, String regexTemplate) {
        super(preferredMessageTemplate);
        this.regexTemplate = regexTemplate;
    }

    /**
     * Additional constructor. Use default failed message template.
     * @param regexTemplate see {@link #RegexChecker(String, String)}
     */
    public RegexChecker(String regexTemplate) {
        this(DEFAULT_FAILED_MESSAGE_FORMAT, regexTemplate);
    }

    @Override
    public final boolean isValueCorrect(String value) {
        return Pattern.matches(regexTemplate, value);
    }

    @Override
    protected String getFailedMessage(String messageTemplate, String failedValue) {
        return String.format(messageTemplate, failedValue, regexTemplate);
    }
}
