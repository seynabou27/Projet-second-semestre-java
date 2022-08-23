package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Integer prix;

    @OneToMany(mappedBy = "taille")
    private List<Boisson> boissons = new ArrayList<>();

    @OneToMany(mappedBy = "taille")
    private List<Menu_Taille> menu_Tailles = new ArrayList<>();


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
    public Integer getPrix() {
        return prix;
    }
    public void setPrix(Integer prix) {
        this.prix = prix;
    }
    
}
