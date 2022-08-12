package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Burger;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.BurgerService;

@Controller
public class BurgerController {

    @Autowired
   private BurgerService burgerService;

   @GetMapping({"/Produit"})
    public String burgerAdd(Model model){
      Burger burger = new Burger();
      model.addAttribute("burger", burger);
        return "Produit/ajoutBurger";
    }

    @GetMapping("/burger-list")
    public String getViewListBurger(Model model) {
        List<Burger> burgers = burgerService.getAllBurger();

        model.addAttribute("burgers", burgers);
        return "Produit/burger-list";
    }

    //post burger/////

    @PostMapping("/Produit")
    public String addBurger(@ModelAttribute("burger") Burger burger,Model model) {
        if(burger == null || burger.getNom() == null || burger.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "Produit/burgerAdd";
        }
        burgerService.addBurger(burger);
        if (burger.getId() != null) {
            return "redirect:/burger-list";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "Produit/ajoutBurger";
        }
        
    }
}
