package by.wiskiw.fieldsvalidator.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import by.com.fieldsvalidator.demo.R;
import by.wiskiw.valuevalidator.OperationChain;
import by.wiskiw.valuevalidator.OperationResult;
import by.wiskiw.valuevalidator.operation.Trim;
import by.wiskiw.valuevalidator.operation.check.CheckInRange;
import by.wiskiw.valuevalidator.operation.check.CheckNotEmpty;
import by.wiskiw.valuevalidator.operation.check.CheckNotNull;
import by.wiskiw.valuevalidator.operation.convert.ConvertStringToInt;

public class DemoActivity extends AppCompatActivity {

    private EditText field;

    private OperationChain<String, Integer> chain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        field = findViewById(R.id.field);
        Button runChain = findViewById(R.id.runChain);

        initOperationChain();

        runChain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runChain(field.getText().toString());
            }
        });
    }

    private void initOperationChain() {
        chain = new OperationChain<String, Integer>()
            .then(new CheckNotNull("Value cannot be null!"))
            .then(new Trim())
            .then(new CheckNotEmpty("Value cannot be empty!"))
            .then(new ConvertStringToInt("Failed to convert to int"))
            .then(new CheckInRange("Not in range", 100, 1000))
        ;
    }

    private void runChain(String value) {
        OperationResult<Integer> chainResult = chain.run(value);

        String toastMessage;
        if (chainResult.isCorrect()) {
            toastMessage = "Chain success! " + chainResult.getValue() + 1;
        } else {
            toastMessage = chainResult.getFailedMessages().toString();
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
