package by.wiskiw.valuetransformer.checker;

/**
 * {@link ChainCheckAction} для проверки принадлежность числа типа {@link T} заданному диапазону.
 *
 * @author Andrey Yablonsky
 */
public final class RangeChecker<T> extends ChainCheckAction<Comparable<T>> {

    private static final String DEFAULT_FAILED_MESSAGE = "Value must be in [%d, %d] range!";
    private static final String ACCURATE_DEFAULT_FAILED_MESSAGE = "Value must equals %d!";

    private T minValue;
    private T maxValue;
    private boolean takeBounds;

    /**
     * Основной конструктор.
     *
     * @param minValue нижняя граница диапазона
     * @param maxValue верхняя граница диапазона
     * @param takeBounds учитывать ли границы. Если {@code true}, то значения равные граничным будут допустимы.
     * @param customFailedMessage формат сообщения при ошибке
     */
    public RangeChecker(T minValue, T maxValue, boolean takeBounds, String customFailedMessage) {
        super(customFailedMessage);

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.takeBounds = takeBounds;
    }

    /**
     * Реализация {@link #RangeChecker(T, T, boolean, String)} со стандартным форматом сообщения.
     *
     * @param minValue нижняя граница диапазона
     * @param maxValue верхняя граница диапазона
     * @param takeBounds учитывать ли границы. Если {@code true}, то значения равные граничным будут допустимы.
     */

    public RangeChecker(T minValue, T maxValue, boolean takeBounds) {
        this(minValue, maxValue, takeBounds, DEFAULT_FAILED_MESSAGE);
    }

    /**
     * Дополнительный конструктор. Используется для проверки значения на точное соответствие.
     *
     * @param accurateValue единственно верное значение.
     * @param customFailedMessage формат сообщения при ошибке
     */
    public RangeChecker(T accurateValue, String customFailedMessage) {
        this(accurateValue, accurateValue, true, customFailedMessage);
    }

    /**
     * Реализация {@link #RangeChecker(T, String)} со стандартным форматом сообщения.
     *
     * @param accurateValue единственно верное значение.
     */
    public RangeChecker(T accurateValue) {
        this(accurateValue, ACCURATE_DEFAULT_FAILED_MESSAGE);
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
    protected String getFailedMessage(String preferredMessageTemplate, Comparable<T> failedValue) {
        return String.format(preferredMessageTemplate, minValue, maxValue);
    }
}