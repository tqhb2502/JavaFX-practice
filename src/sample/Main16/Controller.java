package sample.Main16;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;

public class Controller {
    @FXML
    private ImageView imageView;

    private File imageFile = new File("src/sample/Main16/images/thumbnail.png");

    private Image image = new Image(imageFile.toURI().toString());

    public void hideImageView(ActionEvent actionEvent) {
        imageView.setImage(null);
    }

    public void showImageView(ActionEvent actionEvent) {
        imageView.setImage(image);
    }
}
