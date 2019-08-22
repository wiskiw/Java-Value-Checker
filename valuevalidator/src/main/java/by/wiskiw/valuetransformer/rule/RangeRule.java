package by.wiskiw.valuetransformer.rule;

/**
 * {@link RuleAction} для проверки принадлежность числа типа {@link T} заданному диапазону.
 *
 * @author Andrey Yablonsky
 */
public final class RangeRule<T> extends RuleAction<Comparable<T>> {

    private static final String DEFAULT_ERROR_MESSAGE = "Value must be in [%d, %d] range!";
    private static final String DEFAULT_ACCURATE_ERROR_MESSAGE = "Value must equals %d!";

    private T minValue;
    private T maxValue;
    private boolean takeBounds;

    /**
     * Основной конструктор.
     *
     * @param minValue нижняя граница диапазона
     * @param maxValue верхняя граница диапазона
     * @param takeBounds учитывать ли границы. Если {@code true}, то значения равные граничным будут допустимы.
     * @param messageTemplate формат сообщения при ошибке
     */
    public RangeRule(T minValue, T maxValue, boolean takeBounds, String messageTemplate) {
        super(messageTemplate);

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.takeBounds = takeBounds;
    }

    /**
     * Реализация {@link #RangeRule(T, T, boolean, String)} со стандартным форматом сообщения.
     *
     * @param minValue нижняя граница диапазона
     * @param maxValue верхняя граница диапазона
     * @param takeBounds учитывать ли границы. Если {@code true}, то значения равные граничным будут допустимы.
     */

    public RangeRule(T minValue, T maxValue, boolean takeBounds) {
        this(minValue, maxValue, takeBounds, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * Дополнительный конструктор. Используется для проверки значения на точное соответствие.
     *
     * @param accurateValue единственно верное значение.
     * @param messageTemplate формат сообщения при ошибке
     */
    public RangeRule(T accurateValue, String messageTemplate) {
        this(accurateValue, accurateValue, true, messageTemplate);
    }

    /**
     * Реализация {@link #RangeRule(T, String)} со стандартным форматом сообщения.
     *
     * @param accurateValue единственно верное значение.
     */
    public RangeRule(T accurateValue) {
        this(accurateValue, DEFAULT_ACCURATE_ERROR_MESSAGE);
    }

    public T getMinValue() {
        return minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public boolean isTakeBounds() {
        return takeBounds;
    }

    @Override
    public boolean isValueCorrect(Comparable<T> value) {
        boolean compareResult;
        if (takeBounds) {
            compareResult = value.compareTo(minValue) >= 0 && value.compareTo(maxValue) <= 0;
        } else {
            compareResult = value.compareTo(minValue) > 0 && value.compareTo(maxValue) < 0;
        }
        return compareResult;
    }

    @Override
    protected String getFailedMessage(String messageFormat, Comparable<T> failedValue) {
        return String.format(messageFormat, minValue, maxValue);
    }
}