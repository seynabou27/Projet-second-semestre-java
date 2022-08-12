package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Gestionnaire;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
    Gestionnaire findByEmail(String email);

}
