package by.wiskiw.valuetransformer.converter;

import by.wiskiw.valuetransformer.ChainAction;
import by.wiskiw.valuetransformer.ChainActionException;

/**
 * Экшен для преобразования типа {@link A} к типу {@link B}.
 *
 * @author Andrey Yablonsky
 */
public abstract class ChainConvertAction<A, B> implements ChainAction<A, B> {

    private final String preferredFailedMessageTemplate;

    /**
     * Основной конструктор. Позволяет задать собственный шаблон для сообщения об ошибке.
     *
     * @param preferredMessageTemplate шаблон сообщения об ошибки
     */
    public ChainConvertAction(String preferredMessageTemplate) {
        this.preferredFailedMessageTemplate = preferredMessageTemplate;
    }

    /**
     * Выполняет преобразование типа {@link A} к типу {@link B}.
     *
     * @param value значение типа {@link A} для конвертирования
     * @return преобразованное значение типа {@link B}
     * @throws ChainActionException при ошибку конвертирования
     */
    public abstract B convert(A value) throws ChainActionException;

    @Override
    public B execute(A value) throws ChainActionException {
        try {
            return convert(value);
        }
        catch (ChainActionException e) {
            throw new ChainActionException(getFailedMessage(preferredFailedMessageTemplate, value), e);
        }
    }

    /**
     * Возвращает шаблон сообщения для отображения ошибки конвертации.
     *
     * @return предпочитаемый шаблон сообщения об ошибке
     */
    protected String getFailedMessage(String preferredMessageTemplate, A failedValue) {
        return String.format(preferredMessageTemplate, failedValue);
    }

}
