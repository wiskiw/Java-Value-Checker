package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для последовательного выполнения действий {@link ChainAction}.
 *
 * @author Andrey Yablonsky
 */
public final class ActionsExecutor {

    private List<ChainAction<Object, Object>> actions = new ArrayList<>();

    /**
     * Добавляет {@link ChainAction} в список действий.
     */
    public ActionsExecutor add(ChainAction<?, ?> action) {
        actions.add((ChainAction<Object, Object>) action);
        return this;
    }

    /**
     * Убирает {@link ChainAction} из списка действий.
     */
    public ActionsExecutor remove(ChainAction<?, ?> action) {
        actions.remove(action);
        return this;
    }

    /**
     * Последовательно запускает для #value все добавленные {@link #actions}.
     *
     * @param value начально значение
     * @return результат преобразования #value через {@link #actions}
     */
    public <T> ActionsResult<T> run(Object value) {
        ActionsResult<T> result = new ActionsResult<>();

        Object currentValue = value;
        for (ChainAction<Object, Object> converter : actions) {

            try {
                currentValue = converter.execute(currentValue);
            }
            catch (ChainActionException convertException) {
                result.setErrorMessage(convertException.getMessage());
                break;
            }
        }

        result.setValue((T) currentValue);
        return result;
    }

}
