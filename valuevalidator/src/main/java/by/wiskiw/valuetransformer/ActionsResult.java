package by.wiskiw.valuetransformer;

/**
 * Содержит результат выполнения цепочки действий {@link ChainAction}.
 *
 * @author Andrey Yablonsky
 * @see ActionsExecutor
 * @see ChainAction
 */
public class ActionsResult<T> {

    private String errorMessage;

    private T resultValue;

    /**
     * Устанавливает текст сообщения с ошибкой
     *
     * @param message текст сообщения
     */
    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }

    /**
     * Проверяет наличие ошибок в результате проверки данных
     *
     * @return вернет {@code true} если результат проверки не содержит ошибки
     */
    public boolean isCorrect() {
        return errorMessage == null;
    }

    /**
     * Возвращает сообщение об ошибке
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Возвращает значение результата
     */
    public T getValue() {
        return resultValue;
    }

    /**
     * Устанавливает значение результата
     */
    public void setValue(T resultValue) {
        this.resultValue = resultValue;
    }
}
