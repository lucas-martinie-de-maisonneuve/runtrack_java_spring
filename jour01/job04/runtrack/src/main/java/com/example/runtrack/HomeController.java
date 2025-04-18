package com.example.runtrack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/")
    public String home() {
        return greetingMessage; 
    }
}
