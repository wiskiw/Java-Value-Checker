package by.wiskiw.fieldsvalidator.demo;

import android.widget.TextView;
import by.wiskiw.fieldsvalidator.demo.validation.InputValidator;
import by.wiskiw.fieldsvalidator.demo.validation.validateactions.ActionsToValidateActionsAdapter;
import by.wiskiw.fieldsvalidator.demo.validation.inputfetcher.TextViewFetcher;
import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.converter.CharSequenceToStringConverter;
import by.wiskiw.valuetransformer.converter.IntToStringConverter;
import by.wiskiw.valuetransformer.converter.StringToIntConverter;
import by.wiskiw.valuetransformer.rule.LengthRule;
import by.wiskiw.valuetransformer.rule.NotEmptyRule;
import by.wiskiw.valuetransformer.rule.NotNullRule;
import by.wiskiw.valuetransformer.rule.RangeRule;

/**
 * @author Andrey Yablonsky on 20.02.2020
 */
public class TextViewSpecificIntValidator extends InputValidator<TextView, CharSequence, String> {

    private static final ActionsExecutor<CharSequence, String> checkActionsExecutor = new ActionsExecutor<CharSequence, String>()
        .add(new NotNullRule<CharSequence>())
        .add(new CharSequenceToStringConverter())
        .add(new NotEmptyRule())
        .add(new LengthRule(2, 6))
        .add(new StringToIntConverter("Must contains only digits!"))
        .add(new RangeRule<>(2, 20, false))
        .add(new IntToStringConverter());

    public TextViewSpecificIntValidator() {
        super(new TextViewFetcher(), new ActionsToValidateActionsAdapter<>(checkActionsExecutor));
    }
}
