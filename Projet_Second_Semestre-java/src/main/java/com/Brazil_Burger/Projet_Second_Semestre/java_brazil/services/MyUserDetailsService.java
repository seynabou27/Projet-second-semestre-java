package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Role;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.User;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userService.findUserByEmail(username);
            System.out.println(username);
           if(user != null) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.getRole().getLibelle()));
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, roles);
           }
        return null;
    }

    private HashSet<Role> extracted(User user) {
        return user.getRole();
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getLibelle()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    
}
    

