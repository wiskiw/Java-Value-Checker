package by.wiskiw.valuetransformer.converter;

/**
 * {@link ConvertAction} for converting {@link CharSequence} into {@link String}.
 *
 * @author Andrey Yablonsky on 20.02.2020
 */
public final class CharSequenceToStringConverter extends ConvertAction<CharSequence, String> {

    private static final String DEFAULT_FAILED_MESSAGE = "Cannot convert '%s' to CharSequence!";

    public CharSequenceToStringConverter(String messageTemplate) {
        super(messageTemplate);
    }

    public CharSequenceToStringConverter() {
        this(DEFAULT_FAILED_MESSAGE);
    }

    @Override
    public String convert(CharSequence value) {
        return value.toString();
    }
}
