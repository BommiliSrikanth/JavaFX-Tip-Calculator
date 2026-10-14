// Controller for the Tip Calculator FXML
// Handles Calculate Tip and Reset button actions + input validation

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipCalculatorController {

    @FXML
    private TextField billAmountField;

    @FXML
    private TextField tipPercentField;

    @FXML
    private Button calculateButton;

    @FXML
    private Button resetButton;

    @FXML
    private Label tipAmountLabel;

    @FXML
    private Label errorLabel;

    /**
     * Called when "Calculate Tip" button is clicked.
     * Parses inputs, calculates tip, displays result.
     * Catches NumberFormatException for invalid (non-numeric) input.
     */
    @FXML
    private void calculateTip() {
        // Clear previous error
        errorLabel.setText("");

        try {
            // Parse bill amount and tip percentage
            double billAmount = Double.parseDouble(billAmountField.getText().trim());
            double tipPercent = Double.parseDouble(tipPercentField.getText().trim());

            // Basic validation: non-negative values
            if (billAmount < 0 || tipPercent < 0) {
                errorLabel.setText("Error: Values cannot be negative.");
                tipAmountLabel.setText("Tip Amount: $0.00");
                return;
            }

            // Calculate tip amount
            double tipAmount = billAmount * (tipPercent / 100.0);

            // Display formatted result
            tipAmountLabel.setText(String.format("Tip Amount: $%.2f", tipAmount));

        } catch (NumberFormatException e) {
            // Invalid input (non-numeric)
            errorLabel.setText("Error: Invalid input. Please enter numbers.");
            tipAmountLabel.setText("Tip Amount: $0.00");
        }
    }

    /**
     * Called when "Reset" button is clicked.
     * Clears all input fields and labels.
     */
    @FXML
    private void reset() {
        billAmountField.clear();
        tipPercentField.clear();
        tipAmountLabel.setText("Tip Amount: $0.00");
        errorLabel.setText("");
    }
}
