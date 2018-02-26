package me.motyim.learn.spring.springdata;

import me.motyim.learn.spring.springdata.entity.City;
import me.motyim.learn.spring.springdata.entity.Student;
import me.motyim.learn.spring.springdata.entity.StudentHasCity;
import me.motyim.learn.spring.springdata.entity.StudentHasCityPK;
import me.motyim.learn.spring.springdata.repository.CityRepository;
import me.motyim.learn.spring.springdata.repository.StudentHasCityRepository;
import me.motyim.learn.spring.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentHasCityRepository studentHasCityRepository;


    private void saveManyToMany() {

        System.out.println(">> Start Make Entity");

        //save student
        Student std = new Student();
        std.setName("mohamed");
        studentRepository.save(std);
        System.out.println("# User Saved");



        //save City
        City city = new City();
        city.setCityName("alexandria");
        cityRepository.save(city);
        city = cityRepository.save(city);
        System.out.println("# City Saved");

        System.out.println(">> Make ID ");
        StudentHasCityPK studentHasCityPK = new StudentHasCityPK();
        studentHasCityPK.setCityId(city.getId());
        studentHasCityPK.setStudentid(std.getId());

        System.out.println(">> Make Relation");
        StudentHasCity stdCity = new StudentHasCity();
        stdCity.setStudentHasCityPK(studentHasCityPK);
        stdCity.setCity(city);
        stdCity.setNumberOfBuses("2");
        stdCity.setStudent(std);

        studentHasCityRepository.save(stdCity);
        System.out.println("check M-N");
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringdataApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        saveManyToMany();
    }
}
