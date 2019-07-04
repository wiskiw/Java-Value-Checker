package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;

/**
 * Содержит результат выполнения цепочки действий {@link ChainAction}.
 *
 * @author Andrey Yablonsky
 * @see ActionChainExecutor
 * @see ChainAction
 */
public class ChainActionResult<T> {

    private List<String> failedMessages = new ArrayList<>();

    private T resultValue;

    /**
     * Добавляет сообщение о некорректных данных
     *
     * @param message текст сообщения
     */
    public void addFailedMessage(String message) {
        failedMessages.add(message);
    }

    /**
     * Проверяет наличие ошибок в результате проверки данных
     *
     * @return вернет {@code true} если результат проверки не содержит ошибки
     */
    public boolean isCorrect() {
        return failedMessages.isEmpty();
    }

    /**
     * Возвращает список ошибок или пустой список
     */
    public List<String> getFailedMessages() {
        return failedMessages;
    }

    /**
     * Устанавливает список сообщения об ошибке
     *
     * @param failedMessages не {@code null} список.
     */
    public void setFailedMessages(@NonNull List<String> failedMessages) {
        if (failedMessages != null) {
            this.failedMessages = failedMessages;
        } else {
            throw new IllegalArgumentException("List of failed messages must not be null!");
        }
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
