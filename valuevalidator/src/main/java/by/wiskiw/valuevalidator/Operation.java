package by.wiskiw.valuevalidator;

import android.content.Context;
import android.support.annotation.StringRes;
import by.wiskiw.valuevalidator.exception.OperationException;

/**
 * @author Andrey Yablonsky
 */
public abstract class Operation<I, O> {

    private String failedMessage;

    public Operation(String failedMessage) {
        this.failedMessage = failedMessage;
    }

    public Operation(Context context, @StringRes int messageRes) {
        this(context.getString(messageRes));
    }


    protected String getFailedMessage() {
        return failedMessage;
    }

    public abstract O run(I input) throws OperationException;

}
