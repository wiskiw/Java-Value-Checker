package qulix.com.fieldsvalidator.demo.validation.checker;

import qulix.com.fieldsvalidator.demo.validation.ValueChecker;

/**
 * Допускает наличие только цифр в строке
 *
 * @author Andrey Yablonsky
 */
public class OnlyDigitsChecker extends ValueChecker<String> {

    public OnlyDigitsChecker(String failedMessage) {
        super(failedMessage);
    }

    @Override
    public boolean isValueCorrect(String value) {
        String notDigitsRegex = "\\D";
        return value.matches(notDigitsRegex);
    }
}
