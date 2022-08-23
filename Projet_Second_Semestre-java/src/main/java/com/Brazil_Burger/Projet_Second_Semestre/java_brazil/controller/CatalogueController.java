package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Burger;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Frite;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Menu;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.BurgerService;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.FriteServices;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.MenuService;



// import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.CatalogueService;


@Controller
public class CatalogueController {
    @Autowired
    private BurgerService burgerService;

    @Autowired
    private MenuService  menuService;

    @Autowired
    private FriteServices friteServices;
   /*  @Autowired
    private CatalogueService  catalogueService; */
    // @Secured(value = {"ROLE_CLIENT","ROLE_GESTIONNAIRE"})
    @GetMapping({"/"})
    public String catalogue(final Model model){

        final List<Burger> burgers = burgerService.getAllBurger();
        model.addAttribute("burgers", burgers);

        final List<Frite> frites = friteServices.getAllFrites();
        model.addAttribute("frites", frites);
        
        
        return "Catalogue/catalogue_list";
    }
    
//    @Secured(value = {"ROLE_CLIENT"})
   @GetMapping({"/detail/{type}/{id}"})
   public String detailProduit(@PathVariable final Long id,
                                @PathVariable final String type, final Model model){
    System.out.println(type);
        
        if (type.contains("Burger")) {
            final Burger burger = burgerService.findBurgerById(id);
            model.addAttribute("produit", burger);
        }else if (type.contains("Menu")){
            Menu menu = menuService.findMenuById(id);
            model.addAttribute("produit", menu);

        }else if (type.contains("Frite")) {
            Frite frite = friteServices.findFriteById(id);
            model.addAttribute("produit", frite);

        
        }
        return "Catalogue/detail";
    }
}
