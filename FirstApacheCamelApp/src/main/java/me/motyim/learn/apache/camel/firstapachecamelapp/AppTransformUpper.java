package me.motyim.learn.apache.camel.firstapachecamelapp;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 16-May-18
 */
public class AppTransformUpper {

    public String transform(String body){
        return body.toUpperCase();
    }
}
