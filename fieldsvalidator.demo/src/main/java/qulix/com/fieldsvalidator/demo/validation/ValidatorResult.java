package qulix.com.fieldsvalidator.demo.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит результат проверки данных
 *
 * @author Andrey Yablonsky
 * @see ValueValidator
 */
public class ValidatorResult {

    private List<String> failedMessages = new ArrayList<>();

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
}
