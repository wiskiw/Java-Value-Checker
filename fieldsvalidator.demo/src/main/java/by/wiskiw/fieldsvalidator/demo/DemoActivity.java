package by.wiskiw.fieldsvalidator.demo;

import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import by.com.fieldsvalidator.demo.R;
import by.wiskiw.valuetransformer.ValidatorResult;
import by.wiskiw.valuetransformer.ValueTransformer;
import by.wiskiw.valuetransformer.checker.BoundsChecker;
import by.wiskiw.valuetransformer.checker.LengthChecker;
import by.wiskiw.valuetransformer.checker.NotEmptyChecker;
import by.wiskiw.valuetransformer.checker.NotNullChecker;
import by.wiskiw.valuetransformer.checker.OnlyDigitsChecker;
import by.wiskiw.valuetransformer.converter.StringToIntConverter;

public class DemoActivity extends AppCompatActivity {

    private EditText field;

    private ValueTransformer transformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        field = findViewById(R.id.field);

        initTransformer();

        Button convert = findViewById(R.id.start);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert(field.getText().toString());
            }
        });
    }

    private void initTransformer() {
        transformer = new ValueTransformer();

//        transformer.add(new NotNullChecker<String>("Value cannot be null!"))
//            .add(new NotEmptyChecker("Value cannot be empty!"))
//            .add(new LengthChecker("Wrong length!", 2, 6))
//            .add(new OnlyDigitsChecker("String must contains only digits!"))
//            .add(new StringToIntConverter())
//            .add(new BoundsChecker("Wrong value. Must be in [2, 20] range", 2, 20));

        transformer.add(new NotNullChecker<String>())
            .add(new NotEmptyChecker())
            .add(new LengthChecker(2, 6))
            .add(new OnlyDigitsChecker())
            .add(new StringToIntConverter())
            .add(new BoundsChecker(2, 20));

        ValidatorResult<Integer> result = transformer.start("1234");
        int inResult = result.getResultValue();

    }

    private void convert(String value) {
        ValidatorResult<Integer> result = transformer.start(value);

        String toastMessage;
        if (result.isCorrect()) {
            toastMessage = String.format("All data correct: '%s'", result.getResultValue());
        } else {
            List<String> failedMessages = result.getFailedMessages();

            toastMessage = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                String.join("\n", failedMessages) : failedMessages.toString();
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }
}
