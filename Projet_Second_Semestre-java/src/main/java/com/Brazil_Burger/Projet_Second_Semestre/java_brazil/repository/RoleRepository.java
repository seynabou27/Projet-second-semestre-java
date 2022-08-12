package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findByLibelle(String libelle);

}
