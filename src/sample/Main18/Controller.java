package sample.Main18;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField addressBar;

    private WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                addressBar.setText(webEngine.getLocation());
            }
        });
    }

    public void addressBarEnterHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            String address = addressBar.getText();
            webEngine.load(address);
        }
    }

    public void backButtonHandler(ActionEvent actionEvent) {
        if (webEngine.getHistory().getCurrentIndex() > 0) {
            webEngine.getHistory().go(-1);
        }
    }

    public void forwardButtonHandler(ActionEvent actionEvent) {
        if (webEngine.getHistory().getCurrentIndex() < webEngine.getHistory().getEntries().size() - 1) {
            webEngine.getHistory().go(1);
        }
    }
}
