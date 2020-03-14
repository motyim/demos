package me.motyim.springsolrdemo.repository;

import me.motyim.springsolrdemo.docs.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface EmployeeRepository extends SolrCrudRepository<Employee,Integer> {

    List<Employee> findAllByFirstName(String firstname);

}
