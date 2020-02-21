package by.wiskiw.fieldsvalidator.demo.validation.inputvalidator;

import by.wiskiw.fieldsvalidator.demo.validation.InputValidateException;

/**
 * @author Andrey Yablonsky on 21.02.2020
 */
public interface InputValidateActions<I, O> {

    O getValid(I input) throws InputValidateException;

}
