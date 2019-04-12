package qulix.com.fieldsvalidator.demo.validation.checker;

import qulix.com.fieldsvalidator.demo.validation.ValueChecker;

/**
 * Не допускает пустую строку или строку с whitespace символами
 *
 * @author Andrey Yablonsky
 */
public class NotEmptyChecker extends ValueChecker<String> {

    public NotEmptyChecker(String failedMessage) {
        super(failedMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        return !value.replaceAll("\\s", "").isEmpty();
    }
}
