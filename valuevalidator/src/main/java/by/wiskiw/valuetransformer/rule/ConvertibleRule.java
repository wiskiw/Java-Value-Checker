package by.wiskiw.valuetransformer.rule;

import by.wiskiw.valuetransformer.converter.ConvertAction;
import by.wiskiw.valuetransformer.converter.ConvertActionException;

/**
 * Class for checking is it possible to convert value of type {@link A} using {@link A} to {@link B} converter.
 *
 * @author Andrey Yablonsky
 */
public class ConvertibleRule<A, B> extends RuleAction<A> {

    private static final String DEFAULT_ERROR_MESSAGE_FORMAT = "Value '%s' cannot be converted in '%s'!";
    private final ConvertAction<A, B> converter;

    /**
     * Main constructor
     * @param preferredMessageTemplate failed message template. Receive failed value and {@link #converter} class name as arguments.
     * @param converter converter for check
     */
    public ConvertibleRule(String preferredMessageTemplate, ConvertAction<A, B> converter) {
        super(preferredMessageTemplate);
        this.converter = converter;
    }

    /**
     * Additional constructor. Use default failed message template.
     * @param converter see {@link #ConvertibleRule(String, ConvertAction)}
     */
    public ConvertibleRule(ConvertAction<A, B> converter) {
        this(DEFAULT_ERROR_MESSAGE_FORMAT, converter);
    }

    @Override
    public boolean isValueCorrect(A value) {
        boolean isValueCorrect;
        try {
            converter.convert(value);
            isValueCorrect = true;
        }
        catch (ConvertActionException exception) {
            isValueCorrect = false;
        }
        return isValueCorrect;
    }

    @Override
    protected String getFailedMessage(String messageFormat, A failedValue) {
        return String.format(messageFormat, failedValue, converter.getClass().getName());
    }
}
