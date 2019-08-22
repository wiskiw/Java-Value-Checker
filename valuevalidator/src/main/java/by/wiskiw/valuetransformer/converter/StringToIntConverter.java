package by.wiskiw.valuetransformer.converter;

/**
 * {@link ConvertAction} для преобразования {@link String} к {@link Integer}.
 *
 * @author Andrey Yablonsky
 */
public final class StringToIntConverter extends ConvertAction<String, Integer> {

    private static final String DEFAULT_ERROR_MESSAGE = "Cannot convert '%s' to Integer!";

    public StringToIntConverter() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    public StringToIntConverter(String messageFormat) {
        super(messageFormat);
    }

    @Override
    public Integer convert(String value) throws ConvertActionException {
        try {
            return Integer.parseInt(value.trim());
        }
        catch (NumberFormatException nfe) {
            throw new ConvertActionException(nfe);
        }
    }
}
