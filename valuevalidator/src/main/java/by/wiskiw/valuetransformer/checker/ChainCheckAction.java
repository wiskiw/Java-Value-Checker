package by.wiskiw.valuetransformer.checker;

import android.support.annotation.Nullable;
import by.wiskiw.valuetransformer.ChainAction;
import by.wiskiw.valuetransformer.ChainActionException;

/**
 * Экшен для проверки соответствия объекта заданному условию.
 *
 * @author Andrey Yablonsky
 */
public abstract class ChainCheckAction<T> implements ChainAction<T, T> {

    private static final String DEFAULT_FAILED_MESSAGE_FORMAT = "Value '%s' is not correct!";

    private String preferredMessageTemplate;

    /**
     * Основной конструктор. Позволяет задать собственный шаблон для сообщения об ошибке.
     *
     * @param preferredMessageTemplate шаблон сообщения об ошибки.
     */
    public ChainCheckAction(String preferredMessageTemplate) {
        this.preferredMessageTemplate = preferredMessageTemplate;
    }

    /**
     * Выполняет проверку значения
     *
     * @param value значение, которое необходимо проверить
     * @return {@code Boolean#true} если проверка пройдена успешно
     */
    public abstract boolean isValueCorrect(T value);

    @Override
    public T execute(T value) throws ChainActionException {
        if (isValueCorrect(value)) {
            return value;

        } else {
            throw new ChainActionException(getFailedMessage(preferredMessageTemplate, value));
        }
    }

    /**
     * Возвращает шаблон сообщения для отображения ошибки, когда данные не соответствуют требуемому условию.
     *
     * @return предпочитаемый шаблон сообщения об ошибке
     */
    protected String getFailedMessage(@Nullable String preferredMessageTemplate, T failedValue) {
        String template = preferredMessageTemplate != null ? preferredMessageTemplate : DEFAULT_FAILED_MESSAGE_FORMAT;
        return String.format(template, failedValue);
    }

}
