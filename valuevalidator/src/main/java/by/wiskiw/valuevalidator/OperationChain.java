package by.wiskiw.valuevalidator;

import java.util.ArrayList;
import java.util.List;

import by.wiskiw.valuevalidator.exception.OperationException;

/**
 * @author Andrey Yablonsky
 */
public class OperationChain<I, O> {

    private List<Operation> operations = new ArrayList<>();

    public OperationChain<I, O> then(Operation operation) {
        operations.add(operation);
        return this;
    }

    public OperationResult<O> run(I value) {
        Object intermediateValue = value;
        OperationResult<O> result = new OperationResult<>();

        for (Operation operation : operations) {
            try {
                intermediateValue = operation.run(intermediateValue);
            }
            catch (OperationException operationException) {
                result.addFailedMessage(operationException.getMessage());
                break;
            }
            catch (ClassCastException castException) {
                String exceptionMessage =
                    String.format("Cannot execute '%s' operation with '%s' argument. Check operations order.",
                        operation.getClass().getName(), intermediateValue.getClass().getName());

                throw new IllegalStateException(exceptionMessage, castException);
            }
        }

        try {
            // todo fix try-catch
            result.setValue((O) intermediateValue);
        }
        catch (ClassCastException castException) {
            String exceptionMessage = String.format("The last operation in chan must return '%s' but '%s' found. " +
                    "Check operations order.", result.getValue().getClass().getName(), intermediateValue.getClass().getName());

            throw new IllegalStateException(exceptionMessage, castException);
        }

        return result;
    }
}
