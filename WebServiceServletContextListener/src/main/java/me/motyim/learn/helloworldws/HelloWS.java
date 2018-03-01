/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.motyim.learn.helloworldws;

import javax.jws.WebService;

/**
 * @Project : HelloWorldWS
 * @ClassName : HelloWS.java
 * @Description :
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 14, 2018
 */
@WebService
public class HelloWS {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    /**
     * Web service operation
     */
    public Integer newOne(int num, int num2) {
        //TODO write your implementation code here:
        return num+num2;
    }
}
