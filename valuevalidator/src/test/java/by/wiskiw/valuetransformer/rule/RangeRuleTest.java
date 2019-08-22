package by.wiskiw.valuetransformer.rule;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Текст-класс для {@link RangeRule}
 *
 * @author Andrey Yablonsky
 */
class RangeRuleTest {

    @Test
    void intNoBordersRangeTest() {
        int minBorder = -7;
        int maxBorder = 7;

        RangeRule<Integer> rangeRule = new RangeRule<>(minBorder, maxBorder, false);

        String correctMessageTemplate = "Value '%d' must not be correct for inner border (%d..%d)!";

        int maxCorrectValue = maxBorder - 1;
        assertTrue(rangeRule.isValueCorrect(maxCorrectValue),
            String.format(correctMessageTemplate, maxCorrectValue, minBorder, maxBorder));

        int minCorrectValue = minBorder + 1;
        assertTrue(rangeRule.isValueCorrect(minCorrectValue),
            String.format(correctMessageTemplate, minCorrectValue, minBorder, maxBorder));

        int middleCorrectValue = 1;
        assertTrue(rangeRule.isValueCorrect(middleCorrectValue),
            String.format(correctMessageTemplate, middleCorrectValue, minBorder, maxBorder));


        String failedMessageTemplate = "Value '%d' must be correct for inner border (%d..%d)!";

        assertFalse(rangeRule.isValueCorrect(minBorder),
            String.format(failedMessageTemplate, minBorder, minBorder, maxBorder));

        assertFalse(rangeRule.isValueCorrect(maxBorder),
            String.format(failedMessageTemplate, minBorder, minBorder, maxBorder));
    }

    @Test
    void intInBordersRangeTest() {
        int minBorder = -7;
        int maxBorder = 7;

        RangeRule<Integer> rangeRule = new RangeRule<>(minBorder, maxBorder, true);

        String messageTemplate = "Value '%d' must be correct for border [%d..%d]!";

        // проверка границ
        assertTrue(rangeRule.isValueCorrect(minBorder), String.format(messageTemplate, minBorder, minBorder, maxBorder));
        assertTrue(rangeRule.isValueCorrect(maxBorder), String.format(messageTemplate, maxBorder, minBorder, maxBorder));

        int middleCorrectValue = 1;
        assertTrue(rangeRule.isValueCorrect(middleCorrectValue),
            String.format(messageTemplate, middleCorrectValue, minBorder, maxBorder));

    }

    @Test
    void intAccurateTest() {
        int accurateValue = 123;
        RangeRule<Integer> rangeRule = new RangeRule<>(accurateValue);

        assertTrue(rangeRule.isValueCorrect(accurateValue),
            String.format("Value '%d' must be correct for accurate range checker = %d!", accurateValue, accurateValue));

        int wrongValue = accurateValue - 111;
        assertFalse(rangeRule.isValueCorrect(wrongValue),
            String.format("Value '%d' must not be for accurate range checker = %d!", wrongValue, accurateValue));
    }

}
