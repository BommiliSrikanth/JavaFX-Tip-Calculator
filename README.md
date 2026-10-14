# Tip Calculator – JavaFX Application

## Aim
Build a **Tip Calculator** app using JavaFX components, demonstrating:
- Designing a user interface with **FXML**
- Handling user interactions
- Performing **input validation**
- Displaying results

## Features
1. Accepts **Bill Amount** and **Tip Percentage** as user inputs
2. Calculates the **Tip Amount** when "Calculate Tip" is clicked
3. Displays the tip amount in a label (`Tip Amount: $X.XX`)
4. Handles invalid (non-numeric) input with an error message
5. **Reset** button clears all fields and labels

## Project Structure
```
tip-calculator/
├── output/                       # Screenshots of the running app
│   ├── output1.png
│   ├── output2.jpg
│   └── ...
├── src/
│   ├── tip_calculator.fxml       # UI layout (FXML)
│   ├── TipCalculatorController.java
│   └── TipCalculatorApp.java     # Main application class
├── README.md
└── .gitignore
```

## How It Works

### 1. FXML (`tip_calculator.fxml`)
- Root: `VBox`
- Title label
- Two `TextField`s (Bill Amount, Tip Percentage)
- Two `Button`s (Calculate Tip, Reset) linked via `onAction`
- Result label + Error label
- `fx:controller="TipCalculatorController"`

### 2. Controller (`TipCalculatorController.java`)
- `@FXML` injection of all UI components
- `calculateTip()`:
  - Parses doubles
  - Computes `bill * (percent / 100)`
  - Formats result as `$X.XX`
  - Catches `NumberFormatException` → shows error message
- `reset()`: clears fields and labels

### 3. Main (`TipCalculatorApp.java`)
- Extends `Application`
- Loads FXML with `FXMLLoader`
- Sets scene size ≈ 420×450
- Calls `launch(args)` from `main`

## Example Usage

| Input                  | Result                              |
|------------------------|-------------------------------------|
| Bill: 50.00, Tip: 15%  | Tip Amount: $7.50                   |
| Bill: abc, Tip: 15     | Error: Invalid input. Please enter numbers. |
| Click Reset            | All fields & labels cleared         |

## How to Compile & Run

```bash
# Make sure JavaFX is on the module path
cd src
javac --module-path /path/to/javafx-sdk/lib \
      --add-modules javafx.controls,javafx.fxml \
      *.java

java --module-path /path/to/javafx-sdk/lib \
     --add-modules javafx.controls,javafx.fxml \
     TipCalculatorApp
```

(Adjust the JavaFX SDK path according to your installation.)

## Constraints Followed
- FXML and controller correctly linked with `fx:controller`
- Numeric input validation with exception handling
- Graceful error messages for invalid input
- Reset functionality
