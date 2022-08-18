package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Boisson;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.BoissonRepository;

import lombok.extern.java.Log;

@Service
@Log
public class BoissonService {
    @Autowired
    private BoissonRepository boissonRepository;

    public Boisson addBoisson(Boisson boisson) {
        try {
            boissonRepository.save(boisson);
            return boisson;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Boisson> getAllBoissons(){
        return boissonRepository.findAll();
    }


    public Boisson findBoissonById(Long id) {
        return boissonRepository.findById(id).orElse(null);
    }

    

    public boolean deleteBoisson(Boisson boisson) {
        try {
            boissonRepository.delete(boisson);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
}
