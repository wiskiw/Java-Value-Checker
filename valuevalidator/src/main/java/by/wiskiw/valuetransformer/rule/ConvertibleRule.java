package by.wiskiw.valuetransformer.rule;

import by.wiskiw.valuetransformer.converter.ConvertAction;
import by.wiskiw.valuetransformer.converter.ConvertActionException;

/**
 * Class for checking is it possible to convert value of type {@link A} using {@link A} to {@link B} converter.
 *
 * @author Andrey Yablonsky
 * @deprecated Use {@link ConvertAction} with passed message template.
 */
public class ConvertibleRule<A, B> extends RuleAction<A> {

    private static final String DEFAULT_ERROR_MESSAGE_FORMAT = "Value '%s' cannot be converted in '%s'!";
    private final ConvertAction<A, B> converter;

    /**
     * Main constructor
     * @param converter converter for check
     * @param messageTemplate failed message template. Receive failed value and {@link #converter} class name as arguments.
     */
    public ConvertibleRule(ConvertAction<A, B> converter, String messageTemplate) {
        super(messageTemplate);
        this.converter = converter;
    }

    /**
     * Additional constructor. Use default failed message template.
     * @param converter see {@link #ConvertibleRule(ConvertAction, String)}
     */
    public ConvertibleRule(ConvertAction<A, B> converter) {
        this(converter, DEFAULT_ERROR_MESSAGE_FORMAT);
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
