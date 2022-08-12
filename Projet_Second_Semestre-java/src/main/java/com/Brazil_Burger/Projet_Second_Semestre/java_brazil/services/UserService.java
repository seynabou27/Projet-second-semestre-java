package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Gestionnaire;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Role;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.User;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.GestionnaireRepository;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.RoleRepository;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Gestionnaire findAdminByEmail(String email) {
        return gestionnaireRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public User saveUser(User user) {
        try {
            userRepository.save(user);
            return user;
        } catch(Exception e) {
            throw e;
        }
    }
  
}