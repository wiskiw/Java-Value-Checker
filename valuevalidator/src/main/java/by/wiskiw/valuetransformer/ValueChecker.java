package by.wiskiw.valuetransformer;

import by.wiskiw.valuetransformer.converter.ValueConvertException;
import by.wiskiw.valuetransformer.converter.ValueConverter;

/**
 * Класс для описания условия корректности объекта типа {@link T}
 * Частный случай {@link ValueConverter} - не изменяет тип объекта.
 *
 * @author Andrey Yablonsky
 */
public abstract class ValueChecker<T> extends ValueConverter<T, T> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value '%s' is not correct!";

    private boolean isFatal = false;

    public ValueChecker() {
    }

    public ValueChecker(String customFormatMessage) {
        super(customFormatMessage);
    }

    public void setFatal(boolean fatal) {
        isFatal = fatal;
    }

    /**
     * Выполняет проверку значения
     *
     * @param value значение, которое необходимо проверить
     * @return {@code Boolean#true} если проверка пройдена успешно
     */
    public abstract boolean isValueCorrect(T value);

    @Override
    public final T convert(T value) throws ValueConvertException {
        if (isValueCorrect(value)) {
            return value;

        } else {
            throw new ValueConvertException(createFailedMessage(value), isFatal);
        }
    }

    @Override
    protected String getDefaultFailedMessage() {
        return DEFAULT_FAILED_MESSAGE;
    }

}
