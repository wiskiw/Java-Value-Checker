package by.wiskiw.fieldsvalidator.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import by.com.fieldsvalidator.demo.R;
import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.ActionsResult;
import by.wiskiw.valuetransformer.converter.IntToStringConverter;
import by.wiskiw.valuetransformer.converter.StringToIntConverter;
import by.wiskiw.valuetransformer.rule.LengthRule;
import by.wiskiw.valuetransformer.rule.NotEmptyRule;
import by.wiskiw.valuetransformer.rule.NotNullRule;
import by.wiskiw.valuetransformer.rule.RangeRule;

public class DemoActivity extends AppCompatActivity {

    private EditText field;

    private ActionsExecutor actionsExecutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        field = findViewById(R.id.field);

        initChain();

        Button convert = findViewById(R.id.start);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert(field.getText().toString());
            }
        });
    }

    private void initChain() {
        actionsExecutor = new ActionsExecutor();

//        actionsExecutor.add(new NotNullRule<String>("Value cannot be null!"))
//            .add(new NotEmptyRule("Value cannot be empty!"))
//            .add(new LengthRule("Wrong length!", 2, 6))
//            .add(new IntParcelableChecker("String must contains only digits!"))
//            .add(new StringToIntConverter())
//            .add(new RangeRule("Wrong value. Must be in [2, 20] range", 2, 20));

        actionsExecutor.add(new NotNullRule<String>())
            .add(new NotEmptyRule())
            .add(new LengthRule(2, 6))
            .add(new StringToIntConverter())
//            .add(new ConvertibleRule<>(new StringToIntConverter()))  // - alternative
            .add(new RangeRule<>(2, 20, false))
            .add(new IntToStringConverter());
    }

    private void convert(String value) {
        ActionsResult<Integer> result = actionsExecutor.run(value);

        String toastMessage;
        if (result.isCorrect()) {
            toastMessage = String.format("All data are correct: '%s'", result.getValue());

        } else {
            toastMessage = result.getErrorMessage();
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }
}
