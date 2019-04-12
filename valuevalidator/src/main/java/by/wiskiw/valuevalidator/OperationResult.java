package by.wiskiw.valuevalidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Yablonsky
 */
public class OperationResult<R> {

    private List<String> failedMessages = new ArrayList<>();

    private R value;

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

    public void setValue(R value) {
        this.value = value;
    }

    public R getValue() {
        return value;
    }

    /**
     * Возвращает список ошибок или пустой список
     */
    public List<String> getFailedMessages() {
        return failedMessages;
    }

}
