package by.wiskiw.valuetransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит результат проверки данных
 *
 * @author Andrey Yablonsky
 * @see ValueTransformer
 */
public class ValidatorResult<T> {

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

    public void setFailedMessages(List<String> failedMessages) {
        this.failedMessages = failedMessages;
    }

    public T getValue() {
        return resultValue;
    }

    public void setValue(T resultValue) {
        this.resultValue = resultValue;
    }
}
