package by.wiskiw.valuevalidator.operation.check;

import android.content.Context;
import by.wiskiw.valuevalidator.CheckOperation;

/**
 * Проверяет длину строки
 *
 * @author Andrey Yablonsky
 */
public class CheckLength extends CheckOperation<String> {

    private int minLength;
    private int maxLength;

    public CheckLength(String failedMessage, int minLength, int maxLength) {
        super(failedMessage);

        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public CheckLength(Context context, int messageRes, int minLength, int maxLength) {
        super(context, messageRes);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValueCorrect(String value) {
        return new CheckInRange(getFailedMessage(), minLength, maxLength).isValueCorrect(value.length());
    }

}
