package me.motyim.springsolrdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableSolrRepositories
public class SpringSolrDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSolrDemoApplication.class, args);
    }

}
