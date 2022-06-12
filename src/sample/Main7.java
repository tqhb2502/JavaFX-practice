package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main7 {
    public static void main(String[] args) {
        IntegerProperty a = new SimpleIntegerProperty(4);
        IntegerProperty b = new SimpleIntegerProperty();
        System.out.println(b.getValue());
        b.bind(a);
        System.out.println(b.getValue());
        a.setValue(10);
        System.out.println(b.getValue());
        a.setValue(20);
        System.out.println(b.getValue());
        a.setValue(a.divide(2).add(3).getValue());
        System.out.println(a.getValue());
        System.out.println(b.getValue());
    }
}
