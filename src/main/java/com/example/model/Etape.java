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

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
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
