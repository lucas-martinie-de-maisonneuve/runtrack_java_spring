package com.example.runtrack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showView(Model model) {
        List<Fruit> fruits = List.of(
            new Fruit(1, "Banana"),
            new Fruit(2, "Apple"),
            new Fruit(3, "Orange")
        );

        model.addAttribute("fruits", fruits);
        return "view";
    }
}
