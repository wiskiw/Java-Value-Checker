package by.wiskiw.valuetransformer.utils;

import java.util.ArrayList;
import java.util.List;

import by.wiskiw.valuetransformer.ActionsResult;

/**
 * Utility class to combine several {@link ActionsResult}
 *
 * @author Andrey Yablonsky
 */
public class ActionsResultAggregator {

    private final List<ActionsResult<?>> results = new ArrayList<>();

    /**
     * Main constructor
     * @param results result arguments to check correction
     */
    public ActionsResultAggregator(ActionsResult<?>... results) {
        if (results == null) {
            return;
        }

        for (ActionsResult<?> nullableResult : results) {
            add(nullableResult);
        }
    }

    /**
     * Add result to check
     */
    public ActionsResultAggregator add(ActionsResult<?> result) {
        if (result != null) {
            results.add(result);
        }
        return this;
    }

    /**
     * Check if all results are correct.
     */
    public boolean isAllCorrect() {
        for (ActionsResult<?> result : results) {
            if (!result.isCorrect()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return list of error messages or empty list
     * @return not-null list of messages.
     */
    public List<String> getErrorMessages() {
        List<String> messages = new ArrayList<>();
        for (ActionsResult<?> result : results) {
            if (!result.isCorrect()) {
                messages.add(result.getErrorMessage());
            }
        }
        return messages;
    }

}
