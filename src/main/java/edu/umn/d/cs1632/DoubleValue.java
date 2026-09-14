package edu.umn.d.cs1632;

public class DoubleValue extends Value{

    public DoubleValue(String value) {
        Double.valueOf(value);
        this.value = value;
    }
}
