package by.wiskiw.valuevalidator.operation.check;

import android.content.Context;
import by.wiskiw.valuevalidator.CheckOperation;

/**
 * Не допускает пустую строку или строку с whitespace символами
 *
 * @author Andrey Yablonsky
 */
public class CheckNotEmpty extends CheckOperation<String> {

    public CheckNotEmpty(String failedMessage) {
        super(failedMessage);
    }

    public CheckNotEmpty(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }
}
