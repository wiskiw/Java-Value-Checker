package by.wiskiw.valuevalidator.operation.check;

import android.content.Context;
import by.wiskiw.valuevalidator.CheckOperation;

/**
 * Не допускает null значение
 *
 * @author Andrey Yablonsky
 */
public class CheckNotNull extends CheckOperation<Object> {

    public CheckNotNull(String failedMessage) {
        super(failedMessage);
    }

    public CheckNotNull(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(Object value) {
        return value != null;
    }
}
