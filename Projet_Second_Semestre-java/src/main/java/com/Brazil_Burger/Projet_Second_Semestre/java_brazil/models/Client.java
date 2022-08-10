package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLIENT")
@Getter
@Setter
public class Client extends User {

    @Embedded
    private String adresse;
    
}
