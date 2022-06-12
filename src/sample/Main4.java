package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;

public class Main4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login dialog");
        dialog.setHeaderText("Sign in");

        ButtonType buttonTypeLogin = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeLogin, ButtonType.CANCEL);

        Node loginButton = dialog.getDialogPane().lookupButton(buttonTypeLogin);
        loginButton.setDisable(true);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField userName = new TextField();
        userName.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username"), 0, 0);
        grid.add(userName, 1, 0);
        grid.add(new Label("Password"), 0, 1);
        grid.add(password, 1, 1);

        userName.textProperty().addListener((observableValue, s, t1) -> {
            loginButton.setDisable(t1.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeLogin)
                return new Pair<>(userName.getText(), password.getText());
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(UserNamePassword -> {
            System.out.println("Username: " + UserNamePassword.getKey());
            System.out.println("Password: " + UserNamePassword.getValue());
        });
    }
}
