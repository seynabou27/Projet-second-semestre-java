package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Frite;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.FriteRepository;

import lombok.extern.java.Log;

@Service
@Log
public class FriteServices {
    @Autowired
    private FriteRepository friteRepository;

    public Frite addFrite(Frite frite) {
        try {
            friteRepository.save(frite);
            return frite;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Frite> getAllFrites(){
        return friteRepository.findAll();
    }


    public Frite findFriteById(Long id) {
        return friteRepository.findById(id).orElse(null);
    }

    public boolean deleteFrite(Frite frite) {
        try {
            friteRepository.delete(frite);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
}
