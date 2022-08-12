package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    
}
