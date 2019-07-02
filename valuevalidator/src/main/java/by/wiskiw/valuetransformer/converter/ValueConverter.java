package by.wiskiw.valuetransformer.converter;

/**
 * Выполняет преобразование типа {@link A} к типу {@link B}
 *
 * @author Andrey Yablonsky
 */
public abstract class ValueConverter<A, B> {

    private static final String DEFAULT_FAILED_MESSAGE = "Converting failed with value '%s'";

    private String customFormatMessage;

    /**
     * Основной конструктор
     */
    public ValueConverter() {
    }

    /**
     * Дополнительный конструктор. Позволяет задать собственное сообщение об ошибке
     *
     * @param customFailedMessage кастомный формат сообщения об ошибки
     */
    public ValueConverter(String customFailedMessage) {
        this.customFormatMessage = customFailedMessage;
    }

    /**
     * Выполняет преобразование типа {@link A} к типу {@link B}
     *
     * @param value преобразованное значение типа {@link B}
     * @return преобразованное значение типа {@link B}
     * @throws ValueConvertException при ошибку конвертирования
     */
    public abstract B convert(A value) throws ValueConvertException;

    /**
     * Создает сообщение об ошибки.
     * Приоритет отдает кастомному сообщению об ошибке
     *
     * @param failedValue значение, которое вызвало ошибку
     * @return текст сообщения
     */
    protected String createFailedMessage(A failedValue) {
        String customFailedMessage = getCustomFailedMessage();
        String failedMessageFormat = customFailedMessage != null ? customFailedMessage : getDefaultFailedMessage();

        return String.format(failedMessageFormat, failedValue.toString());
    }

    /**
     * Возвращает шаблон стандартного сообщения об ошибке.
     *
     * @return шаблон сообщения об ошибке
     */
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }

    /**
     * Возвращает шаблон кастомного сообщения об ошибке.
     *
     * @return шаблон сообщения об ошибке
     */
    protected String getCustomFailedMessage() {
        return customFormatMessage;
    }
}
