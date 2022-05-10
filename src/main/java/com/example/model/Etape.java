package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.*;

import java.util.List;

import javax.persistence.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="etapes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEtape")
public class Etape {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idEtape")
    // @Column(name="idEtape", unique = true, nullable = false)
    private  Long idEtape;
    
    @Column(name="numeroEtape")
    private int numeroEtape; 

    @Column(name="indication", length = 1000)
    private String indication;
    
    // @OneToOne
    // private Indication indication;

    @OneToMany(mappedBy = "idQuestion")
    @Column(name = "questions")
    private List<Question> questions;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="defi")
    private Defi defi;

    
    
    
    @OneToMany(mappedBy = "indiceEtape")
    private List<Indice> indices;
    
    public int getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(int numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    
}
