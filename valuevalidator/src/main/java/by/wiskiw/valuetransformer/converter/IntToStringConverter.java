package by.wiskiw.valuetransformer.converter;

/**
 * {@link ConvertAction} для преобразования {@link Integer} к {@link String}.
 *
 * @author Andrey Yablonsky
 */
public final class IntToStringConverter extends ConvertAction<Integer, String> {

    private static final String DEFAULT_FAILED_MESSAGE = "Cannot convert '%s' to String!";

    /**
     * Основной конструктор. Позволяет задать собственный шаблон для сообщения об ошибке.
     *
     * @param preferredMessageTemplate шаблон сообщения об ошибки
     */
    public IntToStringConverter(String preferredMessageTemplate) {
        super(preferredMessageTemplate);
    }

    public IntToStringConverter() {
        this(DEFAULT_FAILED_MESSAGE);
    }

    @Override
    public String convert(Integer value) {
        return value.toString();
    }
}
