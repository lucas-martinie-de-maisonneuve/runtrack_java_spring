package com.example.runtrack;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "view";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return "view";
        }
        return "success";
    }

}
