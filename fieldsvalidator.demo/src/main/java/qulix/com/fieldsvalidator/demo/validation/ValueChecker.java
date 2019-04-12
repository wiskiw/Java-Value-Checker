package qulix.com.fieldsvalidator.demo.validation;

/**
 * Выполняет проверку условия
 *
 * @author Andrey Yablonsky
 */
public abstract class ValueChecker<T> {

    private String defaultFailedMessage;

    public ValueChecker(String defaultFailedMessage) {
        this.defaultFailedMessage = defaultFailedMessage;
    }

    /**
     * Выполняет проверку значения
     *
     * @param value значение, которое необходимо проверить
     * @return {@code Boolean#true} если проверка пройдена успешно
     */
    public abstract boolean isValueCorrect(T value);

    /**
     * Возвращает сообщение об ошибки
     *
     * @param failedValue значение, которое не прошло проверку и вызвало ошибку
     * @return текст сообщения
     */
    public final String getFailedMessage(T failedValue) {
        return buildFailedMessage(defaultFailedMessage, failedValue);
    }

    /**
     * Создает сообщение об ошибки
     *
     * @param defaultFailedMessage шаблон или стандартный текст сообщения об ошибки
     * @param failedValue          значение, которое не прошло проверку и вызвало ошибку
     * @return текст сообщения
     */
    protected String buildFailedMessage(String defaultFailedMessage, T failedValue) {
        return defaultFailedMessage;
    }

}
