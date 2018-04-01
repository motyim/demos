package me.motyim.learn.spring.entitydtocinversion.controller;

import me.motyim.learn.spring.entitydtocinversion.dto.CityDto;
import me.motyim.learn.spring.entitydtocinversion.entity.CityEntity;
import me.motyim.learn.spring.entitydtocinversion.service.CityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 01-Apr-18
 */
@RestController
public class CityController {

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    CityService cityService;

    @GetMapping("/city/{id}")
    public ResponseEntity<CityDto> getCity(@PathVariable int id){
        Optional<CityEntity> city = cityService.getCity(id);
        if(city.isPresent()){
            CityDto cityDto = modelMapper.map(city.get(), CityDto.class);
            return new ResponseEntity<>(cityDto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CityDto(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/city")
    public List<CityDto> getAllCities(){
        List<CityEntity> collect = cityService.getAllCity().collect(Collectors.toList());

        //to map list as ... http://modelmapper.org/user-manual/generics/
        Type listType = new TypeToken<List<CityDto>>() {}.getType();
        List<CityDto> result = modelMapper.map(collect, listType);

        return result;

    }


}
