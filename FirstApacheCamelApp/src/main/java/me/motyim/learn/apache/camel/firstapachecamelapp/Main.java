package me.motyim.learn.apache.camel.firstapachecamelapp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 16-May-18
 * link : http://fabian-kostadinov.github.io/2016/01/10/reading-from-and-writing-to-files-in-apache-camel/
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("### App Started ... ");

        AppRouteBuilder routeBuilder = new AppRouteBuilder();

        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(routeBuilder);
            camelContext.start();
            System.out.println("start");
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
            System.out.println("stop");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
