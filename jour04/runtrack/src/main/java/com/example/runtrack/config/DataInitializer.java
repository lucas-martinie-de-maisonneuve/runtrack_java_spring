package com.example.runtrack.config;

import com.example.runtrack.model.Person;
import com.example.runtrack.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(PersonService personService) {
        return args -> {
            Person user = new Person();
            user.setUsername("user");
            user.setPassword("user");
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setPhoneNumber("1234567890");
            user.setRole("USER");
            personService.save(user);

            Person admin = new Person();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setFirstName("Alice");
            admin.setLastName("Smith");
            admin.setPhoneNumber("0987654321");
            admin.setRole("ADMIN");
            personService.save(admin);

            System.out.println(">>> Fake users inserted in H2 DB");
        };
    }
}
