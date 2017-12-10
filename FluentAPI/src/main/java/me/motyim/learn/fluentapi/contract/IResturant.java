package me.motyim.learn.fluentapi.contract;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 10-Dec-17
 */
public interface IResturant {

    IResturant name(String name);
    IMenu show();

}
