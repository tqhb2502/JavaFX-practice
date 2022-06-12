package sample.Main12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ComboBox<String> comboBox;
    public TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList = FXCollections.observableArrayList("Java", "C#", "Python");
        comboBox.setItems(observableList);
    }

    public void comboBoxChanged (ActionEvent actionEvent) {
        textField.setText(comboBox.getValue());
    }
}
