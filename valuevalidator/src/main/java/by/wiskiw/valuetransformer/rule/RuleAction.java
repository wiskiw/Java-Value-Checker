package by.wiskiw.valuetransformer.rule;

import by.wiskiw.valuetransformer.ChainAction;
import by.wiskiw.valuetransformer.ChainActionException;

/**
 * Экшен для проверки соответствия объекта заданному условию.
 *
 * @author Andrey Yablonsky
 */
public abstract class RuleAction<T> implements ChainAction<T, T> {

    private static final String DEFAULT_ERROR_MESSAGE_FORMAT = "Value '%s' is not correct!";

    private String messageFormat;

    /**
     * Основной конструктор. Позволяет задать собственный шаблон для сообщения об ошибке.
     *
     * @param messageFormat шаблон сообщения об ошибки.
     */
    public RuleAction(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    /**
     * Secondary constructor. Use default error message template.
     */
    public RuleAction() {
        this(DEFAULT_ERROR_MESSAGE_FORMAT);
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
            throw new ChainActionException(getFailedMessage(messageFormat, value));
        }
    }

    /**
     * Возвращает шаблон сообщения для отображения ошибки, когда данные не соответствуют требуемому условию.
     *
     * @return предпочитаемый шаблон сообщения об ошибке
     */
    protected String getFailedMessage(String messageFormat, T failedValue) {
        return String.format(messageFormat, failedValue);
    }

}
