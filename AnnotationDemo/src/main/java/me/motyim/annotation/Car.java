package me.motyim.annotation;

public class Car {

    @JsonField("manufacturer")
    private final String make;
    @JsonField
    private final String model;
    private final String year;

    @JsonField("price")
    private final int x ;

    @JsonField("maintain")
    private int[] array ;

    public Car(String make, String model, String year, int x, int[] array) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.x = x;
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getX() {
        return x;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
