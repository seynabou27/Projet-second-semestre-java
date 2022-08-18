package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private int prix;
    private String type_frite;
    private String details;
    private String type;

    public String getType_frite() {
        return type_frite;
    }
    public void setType_frite(String type_frite) {
        this.type_frite = type_frite;
    }
   
    
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    private String images;
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
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }


    
}
