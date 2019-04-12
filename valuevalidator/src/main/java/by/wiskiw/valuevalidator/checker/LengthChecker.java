package by.wiskiw.valuevalidator.checker;

import android.content.Context;
import by.wiskiw.valuevalidator.ValueChecker;

/**
 * Проверяет длину строки
 *
 * @author Andrey Yablonsky
 */
public class LengthChecker extends ValueChecker<String> {

    private int minLength;
    private int maxLength;

    public LengthChecker(String failedMessage, int minLength, int maxLength) {
        super(failedMessage);

        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public LengthChecker(Context context, int messageRes, int minLength, int maxLength) {
        super(context, messageRes);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValueCorrect(String value) {

        int len = value.length();
        return minLength <= len && len <= maxLength;
    }

}
