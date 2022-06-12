package sample.Main19;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField JavaTextField;
    @FXML
    private TextField CSharpTextField;
    @FXML
    private TextField PythonTextField;

    public void submitButtonHandler(ActionEvent clickSubmitButtonEvent) {
        try {
            int JavaValue = Integer.parseInt(JavaTextField.getText());
            int CSharpValue = Integer.parseInt(CSharpTextField.getText());
            int PythonValue = Integer.parseInt(PythonTextField.getText());
            PieChart.Data JavaData = new PieChart.Data("Java", JavaValue);
            PieChart.Data CSharpData = new PieChart.Data("C#", CSharpValue);
            PieChart.Data PythonData = new PieChart.Data("Python", PythonValue);
            pieChart.getData().clear();
            pieChart.getData().addAll(JavaData, CSharpData, PythonData);
            for (PieChart.Data currentData: pieChart.getData()) {
                currentData.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, clickPieChartDataEvent -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("So nguoi dung " + currentData.getName());
                    alert.setContentText("So nguoi dung " + currentData.getName() + " la: " + (int) currentData.getPieValue());
                    alert.show();
                });
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
