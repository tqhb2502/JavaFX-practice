package sample.Main14;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Slider slider;
    @FXML
    private TextField textField;

    private final double INITIAL_VALUE = 50;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.setValue(INITIAL_VALUE);
        textField.setText(String.valueOf(INITIAL_VALUE));
        textField.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
    }
}
