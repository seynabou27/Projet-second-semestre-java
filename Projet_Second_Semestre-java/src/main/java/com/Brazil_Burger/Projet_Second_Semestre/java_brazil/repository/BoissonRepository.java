package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Boisson;

@Repository
public interface BoissonRepository extends JpaRepository<Boisson, Long> {
    
}
