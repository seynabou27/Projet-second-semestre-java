package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("GESTIONNAIRE")
@Getter
@Setter
public class Gestionnaire  extends User {
    
}
