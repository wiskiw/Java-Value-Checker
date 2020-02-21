package by.wiskiw.fieldsvalidator.demo.validation;

import android.support.annotation.NonNull;
import by.wiskiw.fieldsvalidator.demo.validation.inputfetcher.InputValueFetcher;
import by.wiskiw.fieldsvalidator.demo.validation.validateactions.InputValidateActions;

/**
 * Todo rename
 * todo comments
 * @author Andrey Yablonsky on 20.02.2020
 */
public class InputValidator<F, FV, R> {

    private final InputValueFetcher<F, FV> valueFetcher;

    private InputValidateActions<FV, R> inputValidateActions = new EmptyValidateActions<>();

    public InputValidator(@NonNull InputValueFetcher<F, FV> valueFetcher, InputValidateActions<FV, R> inputValidateActions) {
        this.valueFetcher = valueFetcher;
        this.inputValidateActions = inputValidateActions;
    }

    public InputValidator(@NonNull InputValueFetcher<F, FV> valueFetcher) {
        this.valueFetcher = valueFetcher;
    }

    protected void setInputValidateActions(@NonNull InputValidateActions<FV, R> inputValidateActions) {
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

    private static final class EmptyValidateActions<I, O> implements InputValidateActions<I, O> {

        @Override
        public O getValid(I input) throws InputValidateException {
            return (O) input;
        }
    }

}
