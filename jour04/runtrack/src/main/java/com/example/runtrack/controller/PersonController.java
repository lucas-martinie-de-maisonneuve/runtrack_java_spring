package com.example.runtrack.controller;

import com.example.runtrack.model.Person;
import com.example.runtrack.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
            return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }
}
