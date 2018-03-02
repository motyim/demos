package me.motyim.learn.webservicerest.server;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @param <T>
 * @since Mar 2, 2018 
 */
@XmlRootElement
public class Respons<T>{
    private T data ; 

    public Respons() {
    }

    public Respons(T data) {
        this.data = data;
    }

    

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
