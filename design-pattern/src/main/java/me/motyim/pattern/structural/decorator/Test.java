package me.motyim.pattern.structural.decorator;

public class Test {
    public static void main(String[] args) {
        Sandwich sandwich = new SimpleSandwich();
        System.out.println(sandwich.make());

        Sandwich sandwich2 = new MeatDecorator(new DressingDecorator(new SimpleSandwich()));
        System.out.println(sandwich2.make());
    }
}
