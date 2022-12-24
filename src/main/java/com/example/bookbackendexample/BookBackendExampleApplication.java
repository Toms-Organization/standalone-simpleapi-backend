package com.example.bookbackendexample;

import com.example.bookbackendexample.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.bookbackendexample")
public class BookBackendExampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookBackendExampleApplication.class, args);
    }

}
