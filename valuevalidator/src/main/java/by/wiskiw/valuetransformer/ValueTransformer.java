package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

import by.wiskiw.valuetransformer.converter.ValueConvertException;
import by.wiskiw.valuetransformer.converter.ValueConverter;

/**
 * Способен преобразовывать значение используя список конвертеров {@link ValueConverter}
 *
 * @author Andrey Yablonsky
 */
public class ValueTransformer {

    private List<ValueConverter<Object, Object>> converters = new ArrayList<>();

    /**
     * Добавляет {@link ValueConverter} в список конвертеров
     */
    public ValueTransformer add(ValueConverter<?, ?> converter) {
        converters.add((ValueConverter<Object, Object>) converter);
        return this;
    }

    /**
     * Убирает {@link ValueConverter} из списка конвертеров
     */
    public ValueTransformer remove(ValueConverter<?, ?> converter) {
        converters.remove(converter);
        return this;
    }

    /**
     * Последовательно запускает для #value все добавленные {@link #converters}
     *
     * @param value начально значение
     * @return результат преобразования #value через {@link #converters}
     */
    public <R> ValidatorResult<R> start(Object value) {
        ValidatorResult<R> result = new ValidatorResult<>();

        Object currentValue = value;
        for (ValueConverter<Object, Object> converter : converters) {

            try {
                // todo добавить проверку на соответствие типов конвертеров
                currentValue = converter.convert(currentValue);
            }
            catch (ValueConvertException convertException) {
                result.addFailedMessage(convertException.getMessage());

                if (convertException.isFatal()) {
                    break;
                }
            }
        }

        result.setValue((R) currentValue);
        return result;
    }

}
