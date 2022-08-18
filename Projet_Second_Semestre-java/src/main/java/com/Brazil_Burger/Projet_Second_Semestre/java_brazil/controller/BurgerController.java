package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Boisson;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Burger;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Frite;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Taille;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.BoissonService;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.BurgerService;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.FriteServices;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.TailleService;

@Controller
public class BurgerController {

    @Autowired
   private BurgerService burgerService;
   @Autowired 
   private FriteServices friteServices;
   @Autowired
   private TailleService tailleService;
   @Autowired
   private BoissonService boissonService;

   @GetMapping({"/Produit"})
    public String burgerAdd(Model model){
      Burger burger = new Burger();
      model.addAttribute("burger", burger);

        return "Produit/ajoutBurger";
    }

    @GetMapping({"/produit/burger"})
    public String viewListBurger(Model model){
        List<Burger> burgers = burgerService.getAllBurger();
            model.addAttribute("burgers", burgers);
            return "Produit/burger-list";

    }

   

    //ajout frite
    @GetMapping({"/Produit/produitFrite"})
    public String friteAdd(Model model){
        Frite frite = new Frite();
        model.addAttribute("frite", frite);
  
          return "Produit/ajoutFrite";
    }
    //liste frite
    @GetMapping({"/frite-list"})
    public String ViewListFrite(Model model) {
        List<Frite> listFrites = friteServices.getAllFrites();
        model.addAttribute("listFrites", listFrites);
        return "Produit/frite-list";
    }
    //ajout taille
    @GetMapping({"/Produit/tailleBoisson"})
    public String tailleAdd(Model model){
        Taille taille = new Taille();
        model.addAttribute("taille", taille);

        return "Produit/ajoutTaille";
    }
    //listTaill
    @GetMapping({"/tailleList"})
    public String ViewListTaille(Model model) {
        List<Taille> taille =tailleService.getAllTailles();
        model.addAttribute("taille", taille);
        return "Produit/listTaille";
    }
    //ajout boisson
    @GetMapping({"/Produit/Boisson"})
    public String boissonAdd(Model model){
        Boisson boisson = new Boisson();
        model.addAttribute("boisson", boisson);

        return "Produit/ajoutBoisson";
    }
    
////////////////////////////////////Requette POST/////////////////////////////////////////////////
                //post burger/////

    @PostMapping({"/Produit"})
    public String addBurger(@ModelAttribute("burger") Burger burger,Model model) {
        if(burger == null || burger.getNom() == null || burger.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "Produit/burgerAdd";
        }
        burgerService.addBurger(burger);
        if (burger.getId() != null) {
            return "redirect:/produit/burger";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "Produit/produit/burger";
        }
        
    }

    ////////////post frite
    @PostMapping({"/Produit/produitFrite"})
    public String addFrite(@ModelAttribute("frite") Frite frite,Model model) {
        if(frite == null || frite.getNom() == null || frite.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "Produit/friteAdd";
        }
        friteServices.addFrite(frite);
        if (frite.getId() != null) {
            return "redirect:/frite-list";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "Produit/ajoutFrite";
        }
        
    }

    ///post taille
    @PostMapping({"/Produit/tailleBoisson"})
    public String addTaille(@ModelAttribute("taille") Taille taille,Model model) {
        if(taille == null || taille.getNom() == null || taille.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "Produit/tailleAdd";
        }
        tailleService.addTaille(taille);
        if (taille.getId() != null) {
            return "redirect:/tailleList";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "Produit/tailleList";
        }
        
    }

    ///post boisson
    @PostMapping({"/Produit/Boisson"})
    public String addBoisson(@ModelAttribute("boisson") Boisson boisson,Model model) {
        if(boisson == null || boisson.getNom() == null || boisson.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "Produit/boissonAdd";
        }
        boissonService.addBoisson(boisson);
        if (boisson.getId() != null) {
            return "redirect:/ajoutBoisson";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "Produit/ajoutBoisson";
        }
        
    }
}
