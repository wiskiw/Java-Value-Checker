package qulix.com.fieldsvalidator.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import qulix.com.fieldsvalidator.demo.R;

public class DemoActivity extends AppCompatActivity {

    private EditText field;
    private Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = findViewById(R.id.field);
        validate = findViewById(R.id.validate);

    }
}
