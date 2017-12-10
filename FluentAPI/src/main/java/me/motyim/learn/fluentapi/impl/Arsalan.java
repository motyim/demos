package me.motyim.learn.fluentapi.impl;

import me.motyim.learn.fluentapi.contract.IMenu;
import me.motyim.learn.fluentapi.contract.IResturant;

import java.util.Objects;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 10-Dec-17
 */
public class Arsalan implements IResturant{

    String name ;

    public IResturant name(String name) {
        this.name = Objects.requireNonNull(name);
        System.out.println("Customer enter Resturant : "+ this.name);
        return this;
    }

    public IMenu show() {
        ArsalanMenuHandler handler = new ArsalanMenuHandler();
        handler.showMenu();
        return handler;
    }
}
