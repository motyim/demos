package me.motyim.demos.springsecurity.api;

import com.google.common.collect.Lists;
import me.motyim.demos.springsecurity.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentApi {

    List<Student> studentList = Lists.newArrayList(
            new Student(1, "Mohamed"),
            new Student(2, "Ahmed"),
            new Student(3, "Mahmoud")
    );

    @GetMapping("/{id}")
    Student getStudent(@PathVariable int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
