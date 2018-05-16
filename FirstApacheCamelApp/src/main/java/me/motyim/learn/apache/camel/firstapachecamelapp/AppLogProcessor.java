package me.motyim.learn.apache.camel.firstapachecamelapp;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 16-May-18
 */
public class AppLogProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {

        System.out.println("- Now Proccessing the String " + exchange.getIn().getBody(String.class));

    }
}
