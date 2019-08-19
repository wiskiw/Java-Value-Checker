package by.wiskiw.valuetransformer.checker;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Текст-класс для {@link RangeChecker}
 *
 * @author Andrey Yablonsky
 */
class RangeCheckerTest {

    @Test
    void intNoBordersRangeTest() {
        int minBorder = -7;
        int maxBorder = 7;

        RangeChecker<Integer> rangeChecker = new RangeChecker<>(minBorder, maxBorder, false);

        String correctMessageTemplate = "Value '%d' must not be correct for inner border (%d..%d)!";

        int maxCorrectValue = maxBorder - 1;
        assertTrue(rangeChecker.isValueCorrect(maxCorrectValue),
            String.format(correctMessageTemplate, maxCorrectValue, minBorder, maxBorder));

        int minCorrectValue = minBorder + 1;
        assertTrue(rangeChecker.isValueCorrect(minCorrectValue),
            String.format(correctMessageTemplate, minCorrectValue, minBorder, maxBorder));

        int middleCorrectValue = 1;
        assertTrue(rangeChecker.isValueCorrect(middleCorrectValue),
            String.format(correctMessageTemplate, middleCorrectValue, minBorder, maxBorder));


        String failedMessageTemplate = "Value '%d' must be correct for inner border (%d..%d)!";

        assertFalse(rangeChecker.isValueCorrect(minBorder),
            String.format(failedMessageTemplate, minBorder, minBorder, maxBorder));

        assertFalse(rangeChecker.isValueCorrect(maxBorder),
            String.format(failedMessageTemplate, minBorder, minBorder, maxBorder));
    }

    @Test
    void intInBordersRangeTest() {
        int minBorder = -7;
        int maxBorder = 7;

        RangeChecker<Integer> rangeChecker = new RangeChecker<>(minBorder, maxBorder, true);

        String messageTemplate = "Value '%d' must be correct for border [%d..%d]!";

        // проверка границ
        assertTrue(rangeChecker.isValueCorrect(minBorder), String.format(messageTemplate, minBorder, minBorder, maxBorder));
        assertTrue(rangeChecker.isValueCorrect(maxBorder), String.format(messageTemplate, maxBorder, minBorder, maxBorder));

        int middleCorrectValue = 1;
        assertTrue(rangeChecker.isValueCorrect(middleCorrectValue),
            String.format(messageTemplate, middleCorrectValue, minBorder, maxBorder));

    }

    @Test
    void intAccurateTest() {
        int accurateValue = 123;
        RangeChecker<Integer> rangeChecker = new RangeChecker<>(accurateValue);

        assertTrue(rangeChecker.isValueCorrect(accurateValue),
            String.format("Value '%d' must be correct for accurate range checker = %d!", accurateValue, accurateValue));

        int wrongValue = accurateValue - 111;
        assertFalse(rangeChecker.isValueCorrect(wrongValue),
            String.format("Value '%d' must not be for accurate range checker = %d!", wrongValue, accurateValue));
    }

}
