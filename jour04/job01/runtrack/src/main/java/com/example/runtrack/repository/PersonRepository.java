package com.example.runtrack.repository;

import com.example.runtrack.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    PersonModel findByUsername(String username);
}
