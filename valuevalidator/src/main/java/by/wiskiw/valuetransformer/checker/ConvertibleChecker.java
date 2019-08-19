package by.wiskiw.valuetransformer.checker;

import by.wiskiw.valuetransformer.ChainActionException;
import by.wiskiw.valuetransformer.converter.ChainConvertAction;

/**
 * Class for checking is it possible to convert value of type {@link A} using {@link A} to {@link B} converter.
 *
 * @author Andrey Yablonsky
 */
public class ConvertibleChecker<A, B> extends ChainCheckAction<A> {

    private static final String DEFAULT_FAILED_MESSAGE_FORMAT = "Value '%s' cannot be converted in '%s'!";
    private final ChainConvertAction<A, B> converter;

    /**
     * Main constructor
     * @param preferredMessageTemplate failed message template. Receive failed value and {@link #converter} class name as arguments.
     * @param converter converter for check
     */
    public ConvertibleChecker(String preferredMessageTemplate, ChainConvertAction<A, B> converter) {
        super(preferredMessageTemplate);
        this.converter = converter;
    }

    /**
     * Additional constructor. Use default failed message template.
     * @param converter see {@link #ConvertibleChecker(String, ChainConvertAction)}
     */
    public ConvertibleChecker(ChainConvertAction<A, B> converter) {
        this(DEFAULT_FAILED_MESSAGE_FORMAT, converter);
    }

    @Override
    public boolean isValueCorrect(A value) {
        boolean isValueCorrect;
        try {
            converter.convert(value);
            isValueCorrect = true;
        }
        catch (ChainActionException exception) {
            isValueCorrect = false;
        }
        return isValueCorrect;
    }

    @Override
    protected String getFailedMessage(String preferredMessageTemplate, A failedValue) {
        return String.format(preferredMessageTemplate, failedValue, converter.getClass().getName());
    }
}
