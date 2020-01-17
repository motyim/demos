package me.motyim.docker.pageviewservice;

import me.motyim.docker.pageviewservice.domain.PageView;
import me.motyim.docker.pageviewservice.repository.PageViewRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PageViewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageViewServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PageViewRepo repo){
        return args -> {
            PageView pageView = new PageView();
            pageView.setPageUrl("motyim.me");
            repo.save(pageView);
            System.out.println("saved");
        };
    }
}
