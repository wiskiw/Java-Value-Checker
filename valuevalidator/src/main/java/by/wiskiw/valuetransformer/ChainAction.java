package by.wiskiw.valuetransformer;

/**
 * Абстрактное действие для выполнения операций над объектом.
 * {@link A} - тип входного объекта
 * {@link B} - тип выходного объекта
 *
 * @author Andrey Yablonsky
 */
public interface ChainAction<A, B> {

    /**
     * Запускает действие
     *
     * @param value входной параметр
     * @throws ChainActionException в случае ошибки выполнения действия
     */
    B execute(A value) throws ChainActionException;

}
