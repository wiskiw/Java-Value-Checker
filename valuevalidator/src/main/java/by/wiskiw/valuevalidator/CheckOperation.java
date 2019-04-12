package by.wiskiw.valuevalidator;

import android.content.Context;
import by.wiskiw.valuevalidator.exception.ConvertOperationException;

/**
 * @author Andrey Yablonsky
 */
public abstract class CheckOperation<T> extends Operation<T, T> {

    public CheckOperation(String failedMessage) {
        super(failedMessage);
    }

    public CheckOperation(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public T run(T input) throws ConvertOperationException {
        if (isValueCorrect(input)) {
            return input;
        } else {
            throw new ConvertOperationException(getFailedMessage());
        }
    }

    public abstract boolean isValueCorrect(T value);

}
