package com.example.runtrack.service;

import com.example.runtrack.model.Person;
import com.example.runtrack.repository.PersonRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        if (person.getUsername() == null || person.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username is required!");
        }

        if (person.getPassword() != null && !person.getPassword().isEmpty()) {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
        }

        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
