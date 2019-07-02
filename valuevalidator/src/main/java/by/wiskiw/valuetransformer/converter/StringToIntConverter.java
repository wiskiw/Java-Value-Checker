package by.wiskiw.valuetransformer.converter;

/**
 * Конвертер для преобразования {@link String} к {@link Integer}
 *
 * @author Andrey Yablonsky
 */
public class StringToIntConverter extends ValueConverter<String, Integer> {

    private static final String DEFAULT_FAILED_MESSAGE = "Cannot convert '%s' to Integer!";

    public StringToIntConverter() {
    }

    public StringToIntConverter(String customFailedMessage) {
        super(customFailedMessage);
    }

    @Override
    public Integer convert(String value) throws ValueConvertException {
        try {
            return Integer.parseInt(value.trim());
        }
        catch (NumberFormatException nfe) {
            throw new ValueConvertException(createFailedMessage(value), nfe);
        }
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }
}
