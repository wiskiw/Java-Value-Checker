package by.wiskiw.fieldsvalidator.demo.validation.validateactions;

import by.wiskiw.fieldsvalidator.demo.validation.InputValidateException;
import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.ActionsResult;

/**
 * Адаптер для запуска {@link ActionsExecutor} в качестве валидатора вводных данных {@link InputValidateActions}
 *
 * @author Andrey Yablonsky on 21.02.2020
 */
public class ActionsToValidateActionsAdapter<I, O> implements InputValidateActions<I, O> {

    private final ActionsExecutor<I, O> actionsExecutor;

    public ActionsToValidateActionsAdapter(ActionsExecutor<I, O> actionsExecutor) {
        this.actionsExecutor = actionsExecutor;
    }

    @Override
    public O getValid(I input) throws InputValidateException {
        ActionsResult<O> actionResult = actionsExecutor.run(input);

        if (actionResult.isCorrect()) {
            return actionResult.getValue();
        } else {
            throw new InputValidateException(actionResult.getErrorMessage());
        }
    }
}
