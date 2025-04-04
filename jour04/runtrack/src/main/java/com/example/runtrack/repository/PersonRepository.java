package com.example.runtrack.repository;

import com.example.runtrack.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
