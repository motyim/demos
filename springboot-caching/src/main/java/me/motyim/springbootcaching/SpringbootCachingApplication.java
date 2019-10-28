package me.motyim.springbootcaching;

import me.motyim.springbootcaching.model.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class SpringbootCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCachingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookRepository bookRepository){
      return new CommandLineRunner() {
          @Override
          public void run(String... args) throws Exception {
              System.out.println(".... Fetching books");
              System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
              System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
              System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
              System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
              System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
              System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
          }
      };
    };

}
