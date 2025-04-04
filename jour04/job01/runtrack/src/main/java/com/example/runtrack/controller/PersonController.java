package com.example.runtrack.controller;

import com.example.runtrack.model.PersonModel;
import com.example.runtrack.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonModel> getAllUsers() {
        return personService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<PersonModel> getUserById(@PathVariable Long id) {
        return personService.getUserById(id);
    }

    @PostMapping
    public PersonModel createUser(@RequestBody PersonModel person) {
        return personService.createUser(person);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        personService.deleteUser(id);
    }
}
