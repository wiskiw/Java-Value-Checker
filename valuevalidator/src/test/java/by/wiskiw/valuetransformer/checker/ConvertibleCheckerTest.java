package by.wiskiw.valuetransformer.checker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.wiskiw.valuetransformer.converter.StringToIntConverter;

/**
 * Текст-класс для {@link ConvertibleChecker}
 *
 * @author Andrey Yablonsky
 */
class ConvertibleCheckerTest {

    @Test
    void stringToIntTest() {
        StringToIntConverter converter = new StringToIntConverter();
        ChainCheckAction<String> checker = new ConvertibleChecker<>(converter);

        String convertibleValue = "123";
        String messageTemplate = "Value '%s' must be corrected for ConvertibleChecker<String, Integer>!";
        assertTrue(checker.isValueCorrect(convertibleValue), String.format(messageTemplate, convertibleValue));

        String negativeConvertibleValue = "-123";
        assertTrue(checker.isValueCorrect(negativeConvertibleValue), String.format(messageTemplate, negativeConvertibleValue));

        String notConvertibleValue = "aaa123";
        String failedMessageTemplate = "Value '%s' must not be corrected for ConvertibleChecker<String, Integer>!";
        assertFalse(checker.isValueCorrect(notConvertibleValue), String.format(failedMessageTemplate, notConvertibleValue));

    }

}
