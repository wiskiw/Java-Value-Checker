package by.wiskiw.fieldsvalidator.demo.validation.inputfetcher;

/**
 * todo comments
 * I - field type
 * V - fetched field value type
 *
 * @author Andrey Yablonsky on 20.02.2020
 */
public interface InputValueFetcher<I, V> {

    V fetch(I input);

}
