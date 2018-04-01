package me.motyim.learn.spring.entitydtocinversion.service;

import me.motyim.learn.spring.entitydtocinversion.entity.CityEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 01-Apr-18
 */
@Service
public class CityService {

    private static  List<CityEntity> entityList ;

    static {
        entityList = new ArrayList<>();
        entityList.addAll(Arrays.asList(new CityEntity[]{
                new CityEntity(1,"Alexandria",25000000,new Date(System.currentTimeMillis())),
                new CityEntity(2,"Giza",25000000,new Date(System.currentTimeMillis())),
                new CityEntity(3,"Libya",25000000,new Date(System.currentTimeMillis())),
                new CityEntity(4,"Syria",25000000,new Date(System.currentTimeMillis())),

        }));
    }


    public Optional<CityEntity> getCity(int id){
        return entityList.stream().filter(i-> i.getId() == id).findFirst();
    }


    public Stream<CityEntity> getAllCity(){
        return entityList.stream();
    }


    public boolean addCity(CityEntity entity){
        entityList.add(entity);
        return true;
    }
}
