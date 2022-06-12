package sample.Main20;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart<String, Number> monthlyIncome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Huy
        XYChart.Series<String, Number> huySeries = new XYChart.Series<>();

        XYChart.Data<String, Number> huyJan = new XYChart.Data<>("Jan", 200);
        XYChart.Data<String, Number> huyFeb = new XYChart.Data<>("Feb", 350);
        XYChart.Data<String, Number> huyMar = new XYChart.Data<>("Mar", 500);
        XYChart.Data<String, Number> huyApr = new XYChart.Data<>("Apr", 400);
        XYChart.Data<String, Number> huyMay = new XYChart.Data<>("May", 700);

        huySeries.getData().addAll(huyJan, huyFeb, huyMar, huyApr, huyMay);
        huySeries.setName("Huy's income");

        //Minh
        XYChart.Series<String, Number> minhSeries = new XYChart.Series<>();

        XYChart.Data<String, Number> minhJan = new XYChart.Data<>("Jan", 250);
        XYChart.Data<String, Number> minhFeb = new XYChart.Data<>("Feb", 200);
        XYChart.Data<String, Number> minhMar = new XYChart.Data<>("Mar", 500);
        XYChart.Data<String, Number> minhApr = new XYChart.Data<>("Apr", 700);
        XYChart.Data<String, Number> minhMay = new XYChart.Data<>("May", 900);

        minhSeries.getData().addAll(minhJan, minhFeb, minhMar, minhApr, minhMay );
        minhSeries.setName("Minh's income");

        monthlyIncome.getData().addAll(huySeries, minhSeries);
    }
}
