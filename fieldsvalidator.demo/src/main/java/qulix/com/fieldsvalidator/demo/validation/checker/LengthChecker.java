package qulix.com.fieldsvalidator.demo.validation.checker;

import qulix.com.fieldsvalidator.demo.validation.ValueChecker;

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

    @Override
    public boolean isValueCorrect(String value) {

        int len = value.length();
        return minLength <= len && len <= maxLength;
    }

}
