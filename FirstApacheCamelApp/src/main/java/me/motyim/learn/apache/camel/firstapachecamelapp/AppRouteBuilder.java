package me.motyim.learn.apache.camel.firstapachecamelapp;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 16-May-18
 */
public class AppRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("file://C:/Users/MY-PC/Desktop/temp/input")
                .process(new AppLogProcessor())
                .bean(new AppTransformUpper(),"transform")
                .to("file://C:/Users/MY-PC/Desktop/temp/output");
    }
}
