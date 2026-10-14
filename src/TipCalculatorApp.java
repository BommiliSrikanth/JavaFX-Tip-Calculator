// Main JavaFX Application – Tip Calculator
// Loads the FXML layout and shows the stage

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file (must be on the classpath / same package folder)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tip_calculator.fxml"));
        Parent root = loader.load();

        // Create scene and set it on the stage
        Scene scene = new Scene(root, 420, 450);

        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
