package by.wiskiw.valuetransformer.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import by.wiskiw.valuetransformer.converter.RegexReplaceConverter;

/**
 * Test for {@link RegexReplaceConverter}
 *
 * @author Andrey Yablonsky on 26.09.2019
 */
class RegexReplaceConverterTest {

    @Test
    void correctRemoveDigitsTest() {
        String sourceString = "    12342 134+-++sadf   sadvervgwaA23421SDFGSasdf asDF adAF  asdf\n\tASDF  AS1235DF";
        String digitsRegex = "\\d";
        String replacement = "_"; // must be same as regex sequence length

        String resultString = new RegexReplaceConverter(digitsRegex, replacement).convert(sourceString);

        assertFalse(resultString.contains(digitsRegex), "Result string must not contains any digits!");
        assertEquals(sourceString.length(), resultString.length(), "Result string must contains the same number of characters!");
    }

    @Test
    void nullRegexTest() {
        Executable throwExecutable = new Executable() {
            String nullRegex = null;
            String replacement = "";

            @Override
            public void execute() throws Throwable {
                new RegexReplaceConverter(nullRegex, replacement);
            }
        };

        assertThrows(IllegalArgumentException.class, throwExecutable,
            "Expected constructor with null regex to throw IllegalArgumentException, but it didn't");
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void nullReplacementTest() {
        String sourceString = "    12342 134+-++sadf   sadvervgwaA23421SDFGSasdf asDF adAF  asdf\n\tASDF  AS1235DF";
        String regex = "\\w";
        String nullReplacement = null;

        String resultString = new RegexReplaceConverter(regex, nullReplacement).convert(sourceString);

        assertFalse(resultString.contains(regex),
            String.format("Result string must not contains any sequence that passed '%s' regex, but it does", regex));
    }

    @Test
    void removeConstructorTest() {
        String sourceString = "    12342 134+-++sadf   sadvervgwaA23421SDFGSasdf asDF adAF  asdf\n\tASDF  AS1235DF";
        String regex = "\\d";

        String resultString = new RegexReplaceConverter(regex).convert(sourceString);

        assertFalse(resultString.contains(regex),
            String.format("Result string must not contains any sequence that passed '%s' regex, but it does", regex));
        assertFalse(resultString.isEmpty(), "Result string must contains contains some characters, but it is empty!");
    }
}
