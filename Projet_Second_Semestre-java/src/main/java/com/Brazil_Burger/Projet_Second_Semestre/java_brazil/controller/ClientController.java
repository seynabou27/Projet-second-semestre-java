package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientController {
    @Secured(value = {"ROLE_CLIENT"})
    @GetMapping({"/listCommande"})
    public String registration(Model model){
       
        return "client/listCommande";
    }
    
}
