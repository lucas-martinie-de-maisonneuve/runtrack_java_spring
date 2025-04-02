package com.example.runtrack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showView(Model model) {
        model.addAttribute("message", "Message loaded using Thymeleaf !");
        return "view";
    }
}
