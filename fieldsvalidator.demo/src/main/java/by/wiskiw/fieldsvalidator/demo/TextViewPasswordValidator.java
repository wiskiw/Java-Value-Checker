package by.wiskiw.fieldsvalidator.demo;

import android.widget.TextView;
import by.wiskiw.fieldsvalidator.demo.validation.InputValidator;
import by.wiskiw.fieldsvalidator.demo.validation.validateactions.ActionsToValidateActionsAdapter;
import by.wiskiw.fieldsvalidator.demo.validation.inputfetcher.TextViewFetcher;
import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.converter.CharSequenceToStringConverter;
import by.wiskiw.valuetransformer.rule.LengthRule;
import by.wiskiw.valuetransformer.rule.NotEmptyRule;
import by.wiskiw.valuetransformer.rule.NotNullRule;

/**
 * @author Andrey Yablonsky on 20.02.2020
 */
public class TextViewPasswordValidator extends InputValidator<TextView, CharSequence, String> {

    private static final ActionsExecutor<CharSequence, String> checkActionsExecutor = new ActionsExecutor<CharSequence, String>()
        .add(new NotNullRule<CharSequence>())
        .add(new CharSequenceToStringConverter())
        .add(new NotEmptyRule())
        .add(new LengthRule(6, 12, "Password must contains %d-%d characters!"));

    public TextViewPasswordValidator() {
        super(new TextViewFetcher(), new ActionsToValidateActionsAdapter<>(checkActionsExecutor));
    }
}
