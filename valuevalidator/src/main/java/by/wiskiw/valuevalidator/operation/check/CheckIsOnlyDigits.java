package by.wiskiw.valuevalidator.operation.check;

import android.content.Context;
import by.wiskiw.valuevalidator.CheckOperation;

/**
 * Допускает наличие только цифр в строке
 *
 * @author Andrey Yablonsky
 */
public class CheckIsOnlyDigits extends CheckOperation<String> {

    public CheckIsOnlyDigits(String failedMessage) {
        super(failedMessage);
    }

    public CheckIsOnlyDigits(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(String value) {
        String notDigitsRegex = "\\D";
        return value.matches(notDigitsRegex);
    }
}
