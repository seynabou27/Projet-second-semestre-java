package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Menu_Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    protected Menu menu ;

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    protected Taille taille ;
}
