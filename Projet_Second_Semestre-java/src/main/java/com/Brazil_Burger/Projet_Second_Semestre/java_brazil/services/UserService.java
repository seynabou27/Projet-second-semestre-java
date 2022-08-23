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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private GestionnaireRepository gestionnaireRepository;
    
    // public UserService(UserRepository userRepository, RoleRepository roleRepository,
    //                     BCryptPasswordEncoder bCryptPasswordEncoder) {
    //     this.userRepository = userRepository;
    //     this.roleRepository = roleRepository;
    //     this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    // }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findUserByNom(String nom) {
        return userRepository.findByEmail(nom);
    }

    public Gestionnaire findGestionnaireByEmail(String email) {
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

    // public User saveUser(User user) {
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     // user.setActive(true);
    //     Role userRole = roleRepository.findByLibelle("CLIENT");
    //     // user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
    //     return userRepository.save(user);
    // }


    
  
}