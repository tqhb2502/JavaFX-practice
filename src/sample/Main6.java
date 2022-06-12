package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main6 {
    public static void main(String[] args) {
        /*myNumber example = new myNumber();
        example.numberProperty().addListener((observableValue, number, t1) -> {
            System.out.println(observableValue);
            System.out.println(number);
            System.out.println(t1);
        });
        example.setNumber(10);
        example.setNumber(20);*/
        IntegerProperty example = new SimpleIntegerProperty();
        example.addListener((observableValue, number, t1) -> {
            System.out.println(observableValue);
            System.out.println(number);
            System.out.println(t1);
        });
        example.set(10);
        example.set(20);
    }
}
