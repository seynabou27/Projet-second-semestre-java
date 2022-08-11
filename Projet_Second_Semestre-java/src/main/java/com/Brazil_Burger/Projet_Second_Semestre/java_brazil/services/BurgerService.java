package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Burger;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.BurgerRepository;

import lombok.extern.java.Log;

@Service
@Log
public class BurgerService {
    @Autowired
    private BurgerRepository burgerRepository;

    public Burger addBurger(Burger burger) {
        try {
            burgerRepository.save(burger);
            return burger;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Burger> getAllBurger(){
        return burgerRepository.findAll();
    }
}
