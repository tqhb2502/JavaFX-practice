package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Huy's software");

        //scene1
        Label label = new Label("Welcome to Huy's software");
        Button button1 = new Button("Start");
        button1.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 300, 250);

        //scene2
        Button button2 = new Button("Back");
        button2.setOnAction(actionEvent -> {
            window.setScene(scene1);
        });
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300, 250);

        window.setScene(scene1);
        window.show();

    }
}
