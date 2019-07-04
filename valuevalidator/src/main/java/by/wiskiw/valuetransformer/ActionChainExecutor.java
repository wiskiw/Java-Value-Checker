package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для последовательного выполнения действий {@link ChainAction}.
 *
 * @author Andrey Yablonsky
 */
public final class ActionChainExecutor {

    private List<ChainAction<Object, Object>> components = new ArrayList<>();

    /**
     * Добавляет {@link ChainAction} в список конвертеров.
     */
    public ActionChainExecutor add(ChainAction<?, ?> converter) {
        components.add((ChainAction<Object, Object>) converter);
        return this;
    }

    /**
     * Убирает {@link ChainAction} из списка конвертеров
     */
    public ActionChainExecutor remove(ChainAction<?, ?> converter) {
        components.remove(converter);
        return this;
    }

    /**
     * Последовательно запускает для #value все добавленные {@link #components}.
     *
     * @param value начально значение
     * @return результат преобразования #value через {@link #components}
     */
    public <T> ChainActionResult<T> run(Object value) {
        ChainActionResult<T> result = new ChainActionResult<>();

        Object currentValue = value;
        for (ChainAction<Object, Object> converter : components) {

            try {
                currentValue = converter.execute(currentValue);
            }
            catch (ChainActionException convertException) {
                result.addFailedMessage(convertException.getMessage());
                break;
            }
        }

        result.setValue((T) currentValue);
        return result;
    }

}
