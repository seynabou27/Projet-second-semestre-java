package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Menu;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.MenuRepository;

import lombok.extern.java.Log;

@Service
@Log
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu addBurger(Menu menu) {
        try {
            menuRepository.save(menu);
            return menu;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Menu> getAllMenu(){
        return menuRepository.findAll();
    }

    public Menu findMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }


    
}
