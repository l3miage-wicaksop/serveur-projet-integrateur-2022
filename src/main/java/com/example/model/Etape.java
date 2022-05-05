package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Embeddable
public abstract class Etape {
    
    @Id
    @GeneratedValue
    private  int identifiant;
    
    private int numeroEtape; 
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Defi defi;
}
