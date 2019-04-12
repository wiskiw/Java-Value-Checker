package by.wiskiw.valuevalidator.checker;

import android.content.Context;
import by.wiskiw.valuevalidator.ValueChecker;

/**
 * Не допускает null значение
 *
 * @author Andrey Yablonsky
 */
public class NotNullChecker<T extends Object> extends ValueChecker<T> {

    public NotNullChecker(String failedMessage) {
        super(failedMessage);
    }

    public NotNullChecker(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(T value) {
        return value != null;
    }
}
