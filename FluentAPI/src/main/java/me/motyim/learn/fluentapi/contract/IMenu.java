package me.motyim.learn.fluentapi.contract;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 10-Dec-17
 */
public interface IMenu {

     IMenu order(int index);
     IMenu eat();
     IMenu pay();
     IItem get(int index);

}
