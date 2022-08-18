package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Taille;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.TailleRepository;

import lombok.extern.java.Log;

@Service
@Log
public class TailleService {
    @Autowired
    private TailleRepository tailleRepository;

    public Taille addTaille(Taille taille) {
        try {
            tailleRepository.save(taille);
            return taille;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Taille> getAllTailles(){
        return tailleRepository.findAll();
    }


    public Taille findTailleById(Long id) {
        return tailleRepository.findById(id).orElse(null);
    }

    

    public boolean deleteTaille(Taille taille) {
        try {
            tailleRepository.delete(taille);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
    
}
