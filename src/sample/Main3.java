package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Huy's sw");

        Button button = new Button("Close");
        button.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Alert information");
            alert.setContentText("Choose your option");

            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNO = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNO, buttonTypeCancel);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
                System.out.println("Code for Yes");
            else if (option.get().getButtonData() == ButtonBar.ButtonData.NO)
                System.out.println("Code for No");
            else
                System.out.println("Code for Cancel");

            String message = option.get().getText();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
