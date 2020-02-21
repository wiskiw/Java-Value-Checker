package by.wiskiw.fieldsvalidator.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import by.com.fieldsvalidator.demo.R;
import by.wiskiw.fieldsvalidator.demo.validation.InputValidateException;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        EditText demoField = findViewById(R.id.demoField);
        findViewById(R.id.demoFieldAction).setOnClickListener(new DemoActionClickListener(demoField));

        EditText passField = findViewById(R.id.passField);
        findViewById(R.id.passFieldAction).setOnClickListener(new PasswordClickListener(passField));
    }

    private final class DemoActionClickListener implements View.OnClickListener {

        private final EditText demoField;

        private DemoActionClickListener(EditText demoField) {
            this.demoField = demoField;
        }

        @Override
        public void onClick(View v) {
            try {
                String value = new TextViewSpecificIntValidator().getValid(demoField);
                Toast.makeText(DemoActivity.this, String.format("All data are correct: '%s'", value),
                    Toast.LENGTH_SHORT).show();
            }
            catch (InputValidateException exception) {
                Toast.makeText(DemoActivity.this, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private final class PasswordClickListener implements View.OnClickListener {

        private final EditText passField;

        private PasswordClickListener(EditText passField) {
            this.passField = passField;
        }

        @Override
        public void onClick(View v) {
            try {
                String password = new TextViewPasswordValidator().getValid(passField);
                Toast.makeText(DemoActivity.this, String.format("Password submitted: '%s'", password),
                    Toast.LENGTH_SHORT).show();
            }
            catch (InputValidateException exception) {
                Toast.makeText(DemoActivity.this, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
