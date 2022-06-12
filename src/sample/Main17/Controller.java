package sample.Main17;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileFilter;

public class Controller {
    @FXML
    private AnchorPane anchorPaneLayout;
    @FXML
    private ImageView imageView;

    public void chooseImage(ActionEvent actionEvent) {
        Stage stage = (Stage) anchorPaneLayout.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a image");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Image file", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString(), 382, 246, false, true);
            imageView.setImage(image);
        }
    }
}
