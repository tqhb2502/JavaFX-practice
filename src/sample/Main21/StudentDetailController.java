package sample.Main21;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class StudentDetailController {
    @FXML
    private Label studentIDLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label majorLabel;

    public void addStudentDetail(Student selectedStudent) {
        studentIDLabel.setText(selectedStudent.getStudentID());
        nameLabel.setText(selectedStudent.getName());
        emailLabel.setText(selectedStudent.getEmail());
        ageLabel.setText(Integer.toString(selectedStudent.getAge()));
        majorLabel.setText(selectedStudent.getMajor());
    }

    public void backButtonHandler(ActionEvent clickBackButton) throws IOException {
        Stage currentStage = (Stage) ((Node) clickBackButton.getSource()).getScene().getWindow();

        URL sampleURL = Objects.requireNonNull(getClass().getResource("sample.fxml"));
        FXMLLoader sampleLoader = new FXMLLoader();
        sampleLoader.setLocation(sampleURL);
        Parent sampleParent = sampleLoader.load();

        Scene sampleScene = new Scene(sampleParent);

        currentStage.setScene(sampleScene);
    }
}
