package com.example.runtrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.runtrack.Person;
import com.example.runtrack.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String home() {
        return "persons";
    }

    @GetMapping("/persons")
    public String getPersons(Model model) {
        model.addAttribute("people", personService.getAllPersons());
        return "persons";
    }

    @PostMapping("/add-persons")
    public String addPerson(Person person) {
        personService.addPerson(person);
        return "redirect:/persons";
    }

    @PostMapping("/delete-person")
    public String deletePerson(Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }

    @PostMapping("/update-person")
    public String updatePerson(Person person) {
        if(person.getId() == null) {
            return "redirect:/persons";
        }
        personService.updatePerson(person);
        return "redirect:/persons";
    }

}
