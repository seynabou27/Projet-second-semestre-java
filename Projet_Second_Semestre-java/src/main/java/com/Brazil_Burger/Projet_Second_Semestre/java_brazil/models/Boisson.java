package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String images;
    private String details;
    private Integer quantiteSotck;

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    protected Taille taille ;

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
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
   
    public Taille getTaille() {
        return taille;
    }
    public void setTaille(Taille taille) {
        this.taille = taille;
    }
    public Integer getQuantiteSotck() {
        return quantiteSotck;
    }
    public void setQuantiteSotck(Integer quantiteSotck) {
        this.quantiteSotck = quantiteSotck;
    } 
}
