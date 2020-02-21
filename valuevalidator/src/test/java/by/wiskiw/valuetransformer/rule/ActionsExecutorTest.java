package by.wiskiw.valuetransformer.rule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.ActionsResult;
import by.wiskiw.valuetransformer.converter.IntToStringConverter;

/**
 * Tests for {@link ActionsExecutor}
 *
 * TODO: add more test cases
 *
 * @author Andrey Yablonsky on 10.10.2019
 */
class ActionsExecutorTest {

    @Test
    void singleRuleActionTest() {
        ActionsExecutor<String, String> notEmptyRuleExecutor = new ActionsExecutor<>(new NotEmptyRule());

        assertTrue(notEmptyRuleExecutor.run("Hello").isCorrect());
        assertFalse(notEmptyRuleExecutor.run("").isCorrect());
    }

    @Test
    void singleConvertActionTest() {
        int intValue = -123;
        String intValueText = "-123";

        ActionsExecutor<Integer, String> intToStringConverterExecutor = new ActionsExecutor<>(new IntToStringConverter());

        ActionsResult<String> correctConvertingResult = intToStringConverterExecutor.run(intValue);
        assertTrue(correctConvertingResult.isCorrect());
        assertEquals(intValueText, correctConvertingResult.getValue());
    }

    @Test
    void singleActionStaticLaunchTest() {
        int intValue = -123;
        String intValueText = "-123";

        assertEquals(intValueText, ActionsExecutor.single(new IntToStringConverter(), intValue).getValue());
    }
}
