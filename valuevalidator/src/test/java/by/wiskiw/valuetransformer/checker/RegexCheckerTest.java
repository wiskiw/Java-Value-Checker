package by.wiskiw.valuetransformer.checker;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Текст-класс для {@link RegexChecker}
 *
 * @author Andrey Yablonsky
 */
class RegexCheckerTest {

    @Test
    void onlyDigitsTest() {
        String onlyDigitsRegex = "-?\\d+";
        String correctValue = "-0123456789";

        ChainCheckAction<String> checker = new RegexChecker(onlyDigitsRegex);

        String correctMessageTemplate = "Value '%s' must be correct for '%s' regex!";
        checkTrue(checker, correctMessageTemplate, onlyDigitsRegex, correctValue);


        String wrongValue = "01234-56789";
        String failedMessageTemplate = "Value '%s' must not be correct for '%s' regex!";
        checkFalse(checker, failedMessageTemplate, onlyDigitsRegex, wrongValue);
    }

    @Test
    void smallLettersTest() {
        String smallLettersRegex = "[a-z]+";
        String correctValue = "adfasdfasdvasaw";

        ChainCheckAction<String> checker = new RegexChecker(smallLettersRegex);

        String correctMessageTemplate = "Value '%s' must be correct for '%s' regex!";
        checkTrue(checker, correctMessageTemplate, smallLettersRegex, correctValue);


        String wrongValue = "qqqqqqqqqqqqqT";
        String failedMessageTemplate = "Value '%s' must not be correct for '%s' regex!";
        checkFalse(checker, failedMessageTemplate, smallLettersRegex, wrongValue);
    }

    private void checkTrue(ChainCheckAction<String> checker, String messageTemplate, String regex, String value) {
        assertTrue(checker.isValueCorrect(value), String.format(messageTemplate, value, regex));
    }

    private void checkFalse(ChainCheckAction<String> checker, String messageTemplate, String regex, String value) {
        assertFalse(checker.isValueCorrect(value), String.format(messageTemplate, value, regex));
    }

}
