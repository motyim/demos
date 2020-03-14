package me.motyim.springsolrdemo.docs;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@SolrDocument(collection = "db")
public class Employee {

    @Id
    @Indexed(name = "id", type = "int")
    private int ID ;
    @Indexed(name = "firstname", type = "string")
    private String firstName;
    @Indexed(name = "lastname", type = "string")
    private String lastName;
    private String gender;
    @Indexed(name = "age", type = "int")
    private int age ;
}
