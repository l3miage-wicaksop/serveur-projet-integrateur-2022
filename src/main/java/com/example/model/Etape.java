package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class Etape {
    
    @Id
    private  int identifiant;
    
    private int numeroEtape; 
    
    
    private Defi defi;
}
