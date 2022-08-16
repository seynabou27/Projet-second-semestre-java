package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Burger;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.BurgerService;



// import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.CatalogueService;


@Controller
public class CatalogueController {
    @Autowired
    
    private BurgerService burgerService;
   /*  @Autowired
    private CatalogueService  catalogueService; */
    @GetMapping({"/"})
    public String catalogue(Model model){

        List<Burger> burgers = burgerService.getAllBurger();
        model.addAttribute("burgers", burgers);
        
        return "Catalogue/catalogue_list";
    }

   @GetMapping({"/detail/{id}"})
   public String detailProduit(@PathVariable Long id,Model model){
    Burger burger = burgerService.findBurgerById(id);
        if(burger == null) {
            model.addAttribute("error", "Categorie introuvable");
            return "Catalogue/Catalogue";
        }
        List<Burger> burgerList = burgerService.getAllBurger();
        model.addAttribute("burgerList", burgerList);


        burgerService.findBurgerById(id);
        return "Catalogue/detail";
    }
}
