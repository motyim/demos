package me.motyim.learn.fluentapi;

import me.motyim.learn.fluentapi.impl.Arsalan;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 11-Dec-17
 */
public class Main {
    public static void main(String[] args) {
        new Arsalan().name("ARSALAN").show().order(0).order(1).eat().pay();
    }
}
