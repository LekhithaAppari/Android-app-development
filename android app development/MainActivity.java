import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;

    private double operand1 = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentInput = inputEditText.getText().toString();

        if (!currentInput.equals("0")) {
            inputEditText.setText(currentInput + buttonText);
        } else {
            inputEditText.setText(buttonText);
        }
    }

    public void onCalculateClick(View view) {
        String currentInput = inputEditText.getText().toString();

        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double operand2 = Double.parseDouble(currentInput);
            double result = performOperation(operand1, operand2, operator);
            inputEditText.setText(String.valueOf(result));
            operand1 = result;
            operator = "";
        }
    }

    private double performOperation(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    // Handle division by zero
                    return 0;
                }
            case "%":
                return a % b;
            default:
                return 0;
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(inputEditText.getText().toString());
        inputEditText.setText("0");
    }
}
