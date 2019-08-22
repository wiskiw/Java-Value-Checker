package by.wiskiw.fieldsvalidator.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import by.com.fieldsvalidator.demo.R;
import by.wiskiw.valuetransformer.AbstractActionsListener;
import by.wiskiw.valuetransformer.ActionsExecutor;
import by.wiskiw.valuetransformer.ChainActionException;
import by.wiskiw.valuetransformer.converter.IntToStringConverter;
import by.wiskiw.valuetransformer.converter.StringToIntConverter;
import by.wiskiw.valuetransformer.rule.LengthRule;
import by.wiskiw.valuetransformer.rule.NotEmptyRule;
import by.wiskiw.valuetransformer.rule.NotNullRule;
import by.wiskiw.valuetransformer.rule.RangeRule;

public class DemoActivity extends AppCompatActivity {

    private EditText field;

    private ActionsExecutor<Integer> checkActionsExecutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        field = findViewById(R.id.field);

        initCheckActions();

        Button convert = findViewById(R.id.start);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkActionsExecutor.run(field.getText().toString());
            }
        });
    }

    private void initCheckActions() {
        checkActionsExecutor = new ActionsExecutor<Integer>()
            .add(new NotNullRule<String>())
            .add(new NotEmptyRule())
            .add(new LengthRule(2, 6))
            .add(new StringToIntConverter("Must contains only digits!"))
            .add(new RangeRule<>(2, 20, false))
            .add(new IntToStringConverter())
            .setListener(new AbstractActionsListener() {
                @Override
                public void onSuccess(Object value) {
                    Toast.makeText(DemoActivity.this,
                        String.format("All data are correct: '%s'", value), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(ChainActionException convertException) {
                    Toast.makeText(DemoActivity.this, convertException.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
    }
}
