package sample.Main21;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> studentIDColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;

    private ObservableList<Student> studentList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        studentList = FXCollections.observableArrayList();
        studentTable.setItems(studentList);
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void addButtonHandler(ActionEvent clickAddButton) {
        Dialog<Student> addStudentDialog = new Dialog<>();
        addStudentDialog.setTitle("Add student");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        addStudentDialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        //GridPane layout
        GridPane studentInfoGrid = new GridPane();
        studentInfoGrid.setHgap(10);
        studentInfoGrid.setVgap(10);

        TextField studentIDTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField majorTextField = new TextField();

        studentInfoGrid.add(new Label("Student ID: "), 0, 0);
        studentInfoGrid.add(studentIDTextField, 1, 0);
        studentInfoGrid.add(new Label("Name: "), 0, 1);
        studentInfoGrid.add(nameTextField, 1, 1);
        studentInfoGrid.add(new Label("Email: "), 0, 2);
        studentInfoGrid.add(emailTextField, 1, 2);
        studentInfoGrid.add(new Label("Age: "), 0, 3);
        studentInfoGrid.add(ageTextField, 1, 3);
        studentInfoGrid.add(new Label("Major: "), 0, 4);
        studentInfoGrid.add(majorTextField, 1, 4);

        addStudentDialog.getDialogPane().setContent(studentInfoGrid);

        addStudentDialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                return new Student(studentIDTextField.getText(), nameTextField.getText(), emailTextField.getText(),
                        Integer.parseInt(ageTextField.getText()), majorTextField.getText());
            }
            return null;
        });

        Optional<Student> result = addStudentDialog.showAndWait();

        result.ifPresent(currentStudent -> {
            studentList.add(currentStudent);
        });
    }

    public void deleteButtonHandler(ActionEvent clickDeleteButton) {
        ObservableList<Student> selectedStudentsList = studentTable.getSelectionModel().getSelectedItems();
        studentList.removeAll(selectedStudentsList);
        studentTable.getSelectionModel().clearSelection();
    }

    public void updateButtonHandler(ActionEvent clickUpdateButton) {
        Student currentStudent = studentTable.getSelectionModel().getSelectedItem();

        //Update student info dialog
        Dialog<Void> updateStudentInfoDialog = new Dialog<>();
        updateStudentInfoDialog.setTitle("Update Student Info");

        updateStudentInfoDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        //Student info grid
        GridPane studentInfoGrid = new GridPane();
        studentInfoGrid.setHgap(10);
        studentInfoGrid.setVgap(10);

        TextField studentIDTextField = new TextField(currentStudent.getStudentID());
        TextField nameTextField = new TextField(currentStudent.getName());
        TextField emailTextField = new TextField(currentStudent.getEmail());
        TextField ageTextField = new TextField(Integer.toString(currentStudent.getAge()));
        TextField majorTextField = new TextField(currentStudent.getMajor());

        studentInfoGrid.add(new Label("Student ID: "), 0, 0);
        studentInfoGrid.add(studentIDTextField, 1, 0);
        studentInfoGrid.add(new Label("Name: "), 0, 1);
        studentInfoGrid.add(nameTextField, 1, 1);
        studentInfoGrid.add(new Label("Email: "), 0, 2);
        studentInfoGrid.add(emailTextField, 1, 2);
        studentInfoGrid.add(new Label("Age: "), 0, 3);
        studentInfoGrid.add(ageTextField, 1, 3);
        studentInfoGrid.add(new Label("Major: "), 0, 4);
        studentInfoGrid.add(majorTextField, 1, 4);

        updateStudentInfoDialog.getDialogPane().setContent(studentInfoGrid);

        updateStudentInfoDialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                currentStudent.setStudentID(studentIDTextField.getText());
                currentStudent.setName(nameTextField.getText());
                currentStudent.setEmail(emailTextField.getText());
                currentStudent.setAge(Integer.parseInt(ageTextField.getText()));
                currentStudent.setMajor(majorTextField.getText());
                studentTable.refresh();
            }
            return null;
        });

        updateStudentInfoDialog.showAndWait();
    }

    /*public void detailButtonHandler(ActionEvent clickDetailButton) {
        Student currentStudent = studentTable.getSelectionModel().getSelectedItem();

        //Student info alert
        Dialog<Void> studentInfoDialog = new Dialog<>();
        studentInfoDialog.setTitle("Student info");
        studentInfoDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        //Student info grid
        GridPane studentInfoGrid = new GridPane();
        studentInfoGrid.setHgap(10);
        studentInfoGrid.setVgap(10);

        TextField studentIDTextField = new TextField(currentStudent.getStudentID());
        studentIDTextField.setDisable(true);
        TextField nameTextField = new TextField(currentStudent.getName());
        nameTextField.setDisable(true);
        TextField emailTextField = new TextField(currentStudent.getEmail());
        emailTextField.setDisable(true);
        TextField ageTextField = new TextField(Integer.toString(currentStudent.getAge()));
        ageTextField.setDisable(true);
        TextField majorTextField = new TextField(currentStudent.getMajor());
        majorTextField.setDisable(true);

        studentInfoGrid.add(new Label("Student ID: "), 0, 0);
        studentInfoGrid.add(studentIDTextField, 1, 0);
        studentInfoGrid.add(new Label("Name: "), 0, 1);
        studentInfoGrid.add(nameTextField, 1, 1);
        studentInfoGrid.add(new Label("Email: "), 0, 2);
        studentInfoGrid.add(emailTextField, 1, 2);
        studentInfoGrid.add(new Label("Age: "), 0, 3);
        studentInfoGrid.add(ageTextField, 1, 3);
        studentInfoGrid.add(new Label("Major: "), 0, 4);
        studentInfoGrid.add(majorTextField, 1, 4);

        studentInfoDialog.getDialogPane().setContent(studentInfoGrid);

        studentInfoDialog.setResultConverter(dialogButton -> {
            return null;
        });

        studentInfoDialog.showAndWait();
    }*/

    public void detailButtonHandler(ActionEvent clickDetailButton) throws IOException {
        Stage currentStage = (Stage) ((Node) clickDetailButton.getSource()).getScene().getWindow();

        URL studentDetailURL = Objects.requireNonNull(getClass().getResource("StudentDetail.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(studentDetailURL);
        Parent studentDetailParent = fxmlLoader.load();
        Scene studentDetailScene = new Scene(studentDetailParent);

        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        StudentDetailController controller = fxmlLoader.getController();
        controller.addStudentDetail(selectedStudent);

        currentStage.setScene(studentDetailScene);
    }

    public void printButtonHandler(ActionEvent clickPrintButton) throws IOException {
        Student currentStudent = studentTable.getSelectionModel().getSelectedItem();

        File studentInfoFile = new File("src/sample/StudentInfo/" + currentStudent.getStudentID() + ".txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(studentInfoFile))) {
            bufferedWriter.write("Student ID: " + currentStudent.getStudentID());
            bufferedWriter.newLine();
            bufferedWriter.write("Name: " + currentStudent.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("Email: " + currentStudent.getEmail());
            bufferedWriter.newLine();
            bufferedWriter.write("Age: " + currentStudent.getAge());
            bufferedWriter.newLine();
            bufferedWriter.write("Major: " + currentStudent.getMajor());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(studentInfoFile);
        }
    }
}
