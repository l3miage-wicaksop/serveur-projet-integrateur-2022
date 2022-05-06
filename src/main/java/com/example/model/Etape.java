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
@Table(name="etapes")
public abstract class Etape {
    
    @Id
    @GeneratedValue
    @Column(name="idEtape")
    private  int idEtape;
    
    @Column(name="numeroEtape")
    private int numeroEtape; 
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="iddefi")
    private Defi defi;

    public int getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(int numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    
}
