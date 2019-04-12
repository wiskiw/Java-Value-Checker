package by.wiskiw.valuevalidator.checker;

import android.content.Context;
import by.wiskiw.valuevalidator.ValueChecker;

/**
 * Допускает наличие только цифр в строке
 *
 * @author Andrey Yablonsky
 */
public class OnlyDigitsChecker extends ValueChecker<String> {

    public OnlyDigitsChecker(String failedMessage) {
        super(failedMessage);
    }

    public OnlyDigitsChecker(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(String value) {
        String notDigitsRegex = "\\D";
        return value.matches(notDigitsRegex);
    }
}
