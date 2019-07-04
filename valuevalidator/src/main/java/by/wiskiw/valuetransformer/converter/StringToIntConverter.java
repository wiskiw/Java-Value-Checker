package by.wiskiw.valuetransformer.converter;

import by.wiskiw.valuetransformer.ChainActionException;

/**
 * {@link ChainConvertAction} для преобразования {@link String} к {@link Integer}.
 *
 * @author Andrey Yablonsky
 */
public final class StringToIntConverter extends ChainConvertAction<String, Integer> {

    private static final String DEFAULT_FAILED_MESSAGE = "Cannot convert '%s' to Integer!";

    public StringToIntConverter() {
        super(DEFAULT_FAILED_MESSAGE);
    }

    public StringToIntConverter(String customFailedMessage) {
        super(customFailedMessage);
    }

    @Override
    public Integer convert(String value) throws ChainActionException {
        try {
            return Integer.parseInt(value.trim());
        }
        catch (NumberFormatException nfe) {
            throw new ChainActionException((value), nfe);
        }
    }
}
