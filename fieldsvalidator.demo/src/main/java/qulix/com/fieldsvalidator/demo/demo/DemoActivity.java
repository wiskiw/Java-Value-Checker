package qulix.com.fieldsvalidator.demo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import qulix.com.fieldsvalidator.demo.R;
import qulix.com.fieldsvalidator.demo.validation.ValidatorResult;
import qulix.com.fieldsvalidator.demo.validation.ValueValidator;
import qulix.com.fieldsvalidator.demo.validation.checker.LengthChecker;
import qulix.com.fieldsvalidator.demo.validation.checker.NotEmptyChecker;
import qulix.com.fieldsvalidator.demo.validation.checker.NotNullChecker;
import qulix.com.fieldsvalidator.demo.validation.checker.OnlyDigitsChecker;

public class DemoActivity extends AppCompatActivity {

    private EditText field;
    private Button validate;

    private ValueValidator<String> validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = findViewById(R.id.field);
        validate = findViewById(R.id.validate);

        initValidator();

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(field.getText().toString());
            }
        });
    }

    private void initValidator() {
        validator = new ValueValidator<>();

        validator.addChecker(new NotNullChecker<String>("Value cannot be null!"), true)
            .addChecker(new NotEmptyChecker("Value cannot be empty!"), true)
            .addChecker(new LengthChecker("Wrong length!", 2, 6))
            .addChecker(new OnlyDigitsChecker("String must contains only digits!"));
    }

    private void validate(String value) {
        ValidatorResult result = validator.validate(value);

        String toastMessage;
        if (result.isCorrect()) {
            toastMessage = "All data correct";
        } else {
            toastMessage = result.getFailedMessages().toString();
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
