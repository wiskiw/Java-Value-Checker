package qulix.com.fieldsvalidator.demo.validation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Выполняет проверку значения
 *
 * @author Andrey Yablonsky
 */
public class ValueValidator<T> {

    private Map<ValueChecker<T>, Boolean> checkerMap = new LinkedHashMap<>();

    /**
     * Добавляет #checker для проверки значения
     *
     * @param breakIfFailed если {@code Boolean#true}, то ошибки проверки, дальнейшие проверки будут прекращены
     */
    public ValueValidator<T> addChecker(ValueChecker<T> checker, boolean breakIfFailed) {
        checkerMap.put(checker, breakIfFailed);
        return this;
    }

    /**
     * @see ValueValidator#addChecker(ValueChecker, boolean)
     */
    public ValueValidator<T> addChecker(ValueChecker<T> checker) {
        return addChecker(checker, false);
    }

    /**
     * Проверяет #value через все добавленные {@link #checkerMap}
     *
     * @param value значение для проверки
     * @return {@code true} если #value прошла все проверки {@link #checkerMap}
     */
    public ValidatorResult validate(T value) {
        ValidatorResult result = new ValidatorResult();

        for (Map.Entry<ValueChecker<T>, Boolean> entry : checkerMap.entrySet()) {

            ValueChecker<T> checker = entry.getKey();
            if (!checker.isValueCorrect(value)) {
                result.addFailedMessage(checker.getFailedMessage(value));

                boolean breakIfFailed = entry.getValue();
                if (breakIfFailed) {
                    break;
                }
            }

        }
        return result;
    }

}
