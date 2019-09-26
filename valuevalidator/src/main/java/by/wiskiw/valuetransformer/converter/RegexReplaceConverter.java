package by.wiskiw.valuetransformer.converter;

import by.wiskiw.valuetransformer.utils.Utils;

/**
 * {@link ConvertAction} to replace sequence of characters that were defined by search pattern {@link #regex}
 * to {@link #replacement} string.
 *
 * @author Andrey Yablonsky
 */
public class RegexReplaceConverter extends ConvertAction<String, String> {

    private static final String DEFAULT_FAILED_MESSAGE = "Failed to replace '%s' to '%s' in '%s'";

    private final String regex;
    private final String replacement;

    /**
     * Main constructor
     * @param regex search pattern {@link #regex} that define sequence of characters to replace
     * @param replacement replacement string. If {@code null} then used empty string.
     */
    public RegexReplaceConverter(String regex, String replacement) {
        super(DEFAULT_FAILED_MESSAGE);

        Utils.checkNotNull(regex, "Regex must no be null!");

        this.regex = regex;
        this.replacement = replacement != null ? replacement : "";
    }

    /**
     * Remove constructor
     * Will remove all passed {@link #regex} sequence
     *
     * @param regex search pattern {@link #regex} that define sequence of characters to remove
     */
    public RegexReplaceConverter(String regex) {
        this(regex, null);
    }

    @Override
    public String convert(String value) {
        if (value != null) {
            return value.replaceAll(regex, replacement);
        } else {
            return null;
        }
    }

    @Override
    protected String getErrorMessage(String messageTemplate, String failedValue) {
        return String.format(messageTemplate, regex, replacement, failedValue);
    }
}
