package com.example.runtrack.controller;
import com.example.runtrack.model.Person;
import com.example.runtrack.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final PersonService personService;

    public AuthController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam(required = false) String phoneNumber) {

        Person person = new Person();
        person.setUsername(username);
        person.setEmail(username);
        person.setPassword(password);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setRole("USER");

        personService.save(person);
        return "redirect:/login";
    }
}
