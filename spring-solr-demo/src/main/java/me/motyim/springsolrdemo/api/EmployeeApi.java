package me.motyim.springsolrdemo.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.motyim.springsolrdemo.docs.Employee;
import me.motyim.springsolrdemo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeApi {

    private EmployeeRepository repository;

    @GetMapping("/employee/{name}")
    public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String name) {
        log.info("name : {}", name);
        List<Employee> employees = repository.findAllByFirstName(name);
        return  ResponseEntity.ok(new ArrayList<>(employees));
    }
}
