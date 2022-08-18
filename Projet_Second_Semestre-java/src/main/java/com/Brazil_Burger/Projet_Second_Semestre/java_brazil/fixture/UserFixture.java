package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.fixture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.UserService;

@Component
public class UserFixture {

    @Autowired
    private UserService userService;

    // @Autowired
    // private BCryptPasswordEncoder encoder;

    public void loadDefaultGestionnaire() {
        // User user = new Gestionnaire();
        // user.setEmail("gestionnaire12@mail.com");
        // user.setNom("gestionnaire");
        // user.setPrenom("gestionnaire");
        // user.setPassword(encoder.encode("passer"));
        // Role role = userService.findRoleByLibelle("GESTIONNAIRE");
        // user.setRole(role);
        // userService.saveUser(user);
    }

   
    
 }
