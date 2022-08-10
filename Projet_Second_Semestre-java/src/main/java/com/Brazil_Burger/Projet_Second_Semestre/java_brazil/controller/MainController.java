package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", "A E221");
        return "index";
    }
    
}
