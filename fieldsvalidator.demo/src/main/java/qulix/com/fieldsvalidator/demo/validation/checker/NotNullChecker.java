package qulix.com.fieldsvalidator.demo.validation.checker;

import qulix.com.fieldsvalidator.demo.validation.ValueChecker;

/**
 * Не допускает null значение
 *
 * @author Andrey Yablonsky
 */
public class NotNullChecker<T extends Object> extends ValueChecker<T> {

    public NotNullChecker(String failedMessage) {
        super(failedMessage);
    }

    @Override
    public boolean isValueCorrect(T value) {
        return value != null;
    }
}
