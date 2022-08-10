package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.CatalogueService;


@Controller
public class CatalogueController {
   /*  @Autowired
    private CatalogueService  catalogueService; */
    @GetMapping({"/Catalogue"})
    public String catalogue(Model model){

        return "Catalogue/catalogue_list";
    }

    @GetMapping({"/Catalogue/detail"})
    public String detail(Model model){

        return "Catalogue/detail";
    }
}
