package by.wiskiw.valuevalidator.checker;

import android.content.Context;
import by.wiskiw.valuevalidator.ValueChecker;

/**
 * Не допускает пустую строку или строку с whitespace символами
 *
 * @author Andrey Yablonsky
 */
public class NotEmptyChecker extends ValueChecker<String> {

    public NotEmptyChecker(String failedMessage) {
        super(failedMessage);
    }

    public NotEmptyChecker(Context context, int messageRes) {
        super(context, messageRes);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }
}
