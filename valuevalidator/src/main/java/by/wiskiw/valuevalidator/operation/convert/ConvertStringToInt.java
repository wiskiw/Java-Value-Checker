package by.wiskiw.valuevalidator.operation.convert;

import by.wiskiw.valuevalidator.Operation;
import by.wiskiw.valuevalidator.exception.ConvertOperationException;

/**
 * @author Andrey Yablonsky
 */
public class ConvertStringToInt extends Operation<String, Integer> {

    public ConvertStringToInt(String failedMessage) {
        super(failedMessage);
    }

    @Override
    public Integer run(String input) throws ConvertOperationException {
        try {
            return Integer.valueOf(input);
        }
        catch (NumberFormatException e) {
            throw new ConvertOperationException(getFailedMessage(), e);
        }
    }
}
