package com.example.bookbackendexample;

import com.example.bookbackendexample.repositories.BookRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(info = @Info(title = "BookBackend API", version = "1.0", description = "Book endpoints"))
@SpringBootApplication(scanBasePackages = "com.example.bookbackendexample")
public class BookBackendExampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookBackendExampleApplication.class, args);
    }

}
