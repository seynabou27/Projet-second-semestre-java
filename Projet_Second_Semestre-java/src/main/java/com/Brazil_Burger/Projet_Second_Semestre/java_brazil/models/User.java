package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@DiscriminatorValue("USER")
public  class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nom;

    protected String prenom;

    protected String email;

    protected String password;

    @ManyToOne
    @JoinColumn(name = "role" , referencedColumnName = "id")
    protected HashSet<Role> role ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public HashSet<Role> getRole() {
        return role;
    }

    public void setRole(HashSet<Role> hashSet) {
        this.role = hashSet;
    }

    public Object getUserName() {
        return null;
    }

    public void setActive(boolean b) {
    }

    public boolean getActive() {
        return false;
    }

    

    


}
