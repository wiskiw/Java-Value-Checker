package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для последовательного выполнения действий {@link ChainAction}.
 *
 * @author Andrey Yablonsky
 */
public final class ActionsExecutor<T> {

    private List<ChainAction<Object, Object>> actions = new ArrayList<>();

    private Listener listener;

    /**
     * Add and immediately execute #action for value #value
     *
     * @param action action to execute.
     * @param value value to process.
     * @param <I> input value type.
     * @param <R> result value type.
     * @return #action execution result for #value.
     */
    public static <I, R> ActionsResult<R> single(ChainAction<I, R> action, I value) {
        return new ActionsExecutor<>(action).run(value);
    }

    /**
     * Main constructor
     */
    public ActionsExecutor() {
    }

    /**
     * Additional constructor.
     * Add #action to execute chain
     *
     * @see #add(ChainAction)
     * @param action first action in chain to execute.
     */
    public ActionsExecutor(ChainAction<?, T> action) {
        add(action);
    }

    /**
     * Добавляет {@link ChainAction} в список действий.
     */
    public ActionsExecutor<T> add(ChainAction<?, ?> action) {
        actions.add((ChainAction<Object, Object>) action);
        return this;
    }

    /**
     * Убирает {@link ChainAction} из списка действий.
     */
    public ActionsExecutor<T> remove(ChainAction<?, ?> action) {
        actions.remove(action);
        return this;
    }

    public ActionsExecutor<T> setListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Последовательно запускает для #value все добавленные {@link #actions}.
     *
     * @param value начально значение
     * @return результат преобразования #value через {@link #actions}
     */
    public ActionsResult<T> run(Object value) {
        ActionsResult<T> result = new ActionsResult<>();

        Object currentValue = value;
        for (ChainAction<Object, Object> converter : actions) {

            try {
                currentValue = converter.execute(currentValue);
            }
            catch (ChainActionException convertException) {
                result.setErrorMessage(convertException.getMessage());

                if (listener != null) {
                    listener.onError(convertException);
                }

                break;
            }
        }

        result.setValue((T) currentValue);

        if (result.isCorrect() && listener != null) {
            listener.onSuccess((T) currentValue);
        }
        return result;
    }

    interface Listener<T> {

        void onSuccess(T value);

        void onError(ChainActionException convertException);
    }

}
