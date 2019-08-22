package by.wiskiw.valuetransformer.converter;

import by.wiskiw.valuetransformer.ChainAction;
import by.wiskiw.valuetransformer.ChainActionException;

/**
 * Экшен для преобразования типа {@link A} к типу {@link B}.
 *
 * @author Andrey Yablonsky
 */
public abstract class ConvertAction<A, B> implements ChainAction<A, B> {

    private final String messageFormat;

    /**
     * Основной конструктор. Позволяет задать собственный шаблон для сообщения об ошибке.
     *
     * @param messageFormat шаблон сообщения об ошибки
     */
    public ConvertAction(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    /**
     * Выполняет преобразование типа {@link A} к типу {@link B}.
     *
     * @param value значение типа {@link A} для конвертирования
     * @return преобразованное значение типа {@link B}
     * @throws ConvertActionException при ошибке конвертирования
     */
    public abstract B convert(A value) throws ConvertActionException;

    @Override
    public B execute(A value) throws ChainActionException {
        try {
            return convert(value);
        }
        catch (ConvertActionException convertException) {
            throw new ChainActionException(getErrorMessage(messageFormat, value), convertException);
        }
    }

    /**
     * Возвращает шаблон сообщения для отображения ошибки конвертации.
     *
     * @return предпочитаемый шаблон сообщения об ошибке
     */
    protected String getErrorMessage(String messageTemplate, A failedValue) {
        return String.format(messageTemplate, failedValue);
    }

}
