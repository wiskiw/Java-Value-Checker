package by.wiskiw.valuetransformer.rule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.wiskiw.valuetransformer.converter.StringToIntConverter;

/**
 * Текст-класс для {@link ConvertibleRule}
 *
 * @author Andrey Yablonsky
 */
class ConvertibleRuleTest {

    @Test
    void stringToIntTest() {
        StringToIntConverter converter = new StringToIntConverter();
        RuleAction<String> checker = new ConvertibleRule<>(converter);

        String convertibleValue = "123";
        String messageTemplate = "Value '%s' must be corrected for ConvertibleRule<String, Integer>!";
        assertTrue(checker.isValueCorrect(convertibleValue), String.format(messageTemplate, convertibleValue));

        String negativeConvertibleValue = "-123";
        assertTrue(checker.isValueCorrect(negativeConvertibleValue), String.format(messageTemplate, negativeConvertibleValue));

        String notConvertibleValue = "aaa123";
        String failedMessageTemplate = "Value '%s' must not be corrected for ConvertibleRule<String, Integer>!";
        assertFalse(checker.isValueCorrect(notConvertibleValue), String.format(failedMessageTemplate, notConvertibleValue));

    }

}
