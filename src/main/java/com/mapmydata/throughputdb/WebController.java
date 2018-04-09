package com.mapmydata.throughputdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @PostMapping("/")
    public String readPerson(@ModelAttribute Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        return "greeting";
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("person", new Person());
        return "home";
    }
}
