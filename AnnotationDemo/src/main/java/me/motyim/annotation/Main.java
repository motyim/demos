package me.motyim.annotation;

public class Main {
    public static void main(String[] args) throws JsonSerializeException {
        Car car = new Car("Ford", "F150", "2018",200,new int [] {1,2,3,5,6});
        JsonSerializer serializer = new JsonSerializer();
        String serialize = serializer.serialize(car);
        System.out.println(serialize);
    }
}
