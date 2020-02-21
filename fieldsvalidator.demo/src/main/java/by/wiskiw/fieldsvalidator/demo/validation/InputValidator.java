package by.wiskiw.fieldsvalidator.demo.validation;

import android.support.annotation.NonNull;
import by.wiskiw.fieldsvalidator.demo.validation.inputfetcher.InputValueFetcher;
import by.wiskiw.fieldsvalidator.demo.validation.inputvalidator.InputValidateActions;

/**
 * Todo rename
 * todo comments
 * @author Andrey Yablonsky on 20.02.2020
 */
public class InputValidator<F, FV, R> {

    private final InputValueFetcher<F, FV> valueFetcher;

    private final InputValidateActions<FV, R> inputValidateActions;

    public InputValidator(@NonNull InputValueFetcher<F, FV> valueFetcher, InputValidateActions<FV, R> inputValidateActions) {
        this.valueFetcher = valueFetcher;
        this.inputValidateActions = inputValidateActions;
    }

    /**
     * todo
     * @param field
     * @return
     * @throws IllegalArgumentException
     */
    public R getValid(F field) throws InputValidateException {
        FV fieldValue = valueFetcher.fetch(field);
        return inputValidateActions.getValid(fieldValue);

    }

}
