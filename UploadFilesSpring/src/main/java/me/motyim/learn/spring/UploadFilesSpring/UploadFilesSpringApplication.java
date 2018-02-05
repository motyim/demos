package me.motyim.learn.spring.UploadFilesSpring;

import me.motyim.learn.spring.UploadFilesSpring.storage.StorageProperties;
import me.motyim.learn.spring.UploadFilesSpring.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFilesSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadFilesSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
