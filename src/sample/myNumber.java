package sample;

import javafx.beans.property.*;

public class myNumber {
    private IntegerProperty number = new SimpleIntegerProperty();

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}
