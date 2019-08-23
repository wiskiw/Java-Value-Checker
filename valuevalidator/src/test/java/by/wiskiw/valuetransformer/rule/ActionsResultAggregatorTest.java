package by.wiskiw.valuetransformer.rule;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.wiskiw.valuetransformer.ActionsResult;
import by.wiskiw.valuetransformer.utils.ActionsResultAggregator;

/**
 * Tests for {@link ActionsResultAggregator}
 * @author Andrey Yablonsky
 */
class ActionsResultAggregatorTest {

    @Test
    void isAllCorrectTest() {
        ActionsResult<String> stringResult = new ActionsResult<>();
        ActionsResult<Integer> intResult = new ActionsResult<>();
        ActionsResult<Boolean> booleanResult = new ActionsResult<>();

        ActionsResultAggregator aggregator = new ActionsResultAggregator(stringResult, intResult)
            .add(booleanResult);

        assertTrue(aggregator.isAllCorrect(), "ActionsResultAggregator#isAllCorrect must return TRUE " +
            "for set of results with null error message!");
    }

    @Test
    void notAllCorrectTest() {
        ActionsResult<String> stringResult = new ActionsResult<>();
        stringResult.setErrorMessage("11");

        ActionsResult<Integer> intResult = new ActionsResult<>();
        ActionsResult<Boolean> booleanResult = new ActionsResult<>();

        ActionsResultAggregator aggregator = new ActionsResultAggregator(stringResult, intResult)
            .add(booleanResult);

        assertFalse(aggregator.isAllCorrect(), "ActionsResultAggregator#isAllCorrect must return FALSE " +
            "because set of result are not completely correct!");
    }

    @Test
    void emptyResultSetTest() {
        ActionsResultAggregator aggregator = new ActionsResultAggregator();
        assertTrue(aggregator.isAllCorrect(), "ActionsResultAggregator#isAllCorrect must return TRUE for empty result set");
    }

    @Test
    void nullResultSetTest() {
        ActionsResultAggregator aggregator = new ActionsResultAggregator(null);
        aggregator.add(null);
        aggregator.add(null);
        assertTrue(aggregator.isAllCorrect(), "ActionsResultAggregator#isAllCorrect must return TRUE for null set result set");
    }

    @Test
    void errorMessagesTest() {
        int errorResultNumber = 2;

        ActionsResult<String> stringErrorResult = new ActionsResult<>();
        stringErrorResult.setErrorMessage("String integer message");

        ActionsResult<Integer> intErrorResult = new ActionsResult<>();
        intErrorResult.setErrorMessage("Error integer message");

        ActionsResult<Boolean> booleanOkResult = new ActionsResult<>();


        ActionsResultAggregator aggregator = new ActionsResultAggregator(stringErrorResult, booleanOkResult, intErrorResult);

        List<String> errorMessages = aggregator.getErrorMessages();

        assertEquals(errorResultNumber, errorMessages.size(), String.format("List of error messages must contains %d items, " +
            "but %d received", errorResultNumber, errorMessages.size()));
    }

}
