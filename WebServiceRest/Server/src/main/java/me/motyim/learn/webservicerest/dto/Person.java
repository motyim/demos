package me.motyim.learn.webservicerest.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 2, 2018 
 */
@XmlRootElement
public class Person implements Serializable{

    private int id ;
    private String name ; 
    private int age ; 
    

    public Person() {
    }

    public Person(int id , String name) {
        this.id = id ;
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person : {id :"+id+" ,name : "+name+", age : "+age+"}";
    }
}
