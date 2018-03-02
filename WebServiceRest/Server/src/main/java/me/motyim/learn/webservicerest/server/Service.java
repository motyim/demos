package me.motyim.learn.webservicerest.server;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 2, 2018 
 */
public class Service {

    private List <Person> list ; 

    
    public Service() {
    
        list = Arrays.asList(new Person(1,"mohamed")
                ,new Person(2,"ahmed")
                ,new Person(3,"mohmoud"));
    }
    
    public boolean add(Person p){
        return list.add(p);
    }
    
    public Optional<Person> get(int id){
        return list.stream().filter(i->i.getId()==id).findFirst();
    }
    
    public Stream<Person> get(){
        return list.stream();
    }
    public boolean remove(int id){
        return list.removeIf(i->i.getId() == id);
    }
    
    public boolean update(int id , Person p ){
        if(remove(id)){
            return add(p);
        }
        return false;
    }
    
    
}
