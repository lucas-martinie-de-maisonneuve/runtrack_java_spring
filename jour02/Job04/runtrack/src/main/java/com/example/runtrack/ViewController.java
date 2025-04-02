package com.example.runtrack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showView(Model model) {
        return "view";
    }

    @PostMapping("/welcome")
    public String handleFormSubmission(@RequestParam("name") String name, Model model) {
        String message = "Welcome, " + name + "!";
        model.addAttribute("message", message);
        model.addAttribute("formStyle", "display: none;");
        return "view";
    }
}
