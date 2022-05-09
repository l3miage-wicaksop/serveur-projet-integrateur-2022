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
    @Column(name="idEtape", unique = true, nullable = false)
    private  Long idEtape;
    
    @Column(name="description")
    private String description; 

    @Column(name="indication", length = 1000)
    private Indication indication;

    // @Column(name = "question", length = 1000)
    // private String question;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="question")
    private Question question;

    // @Column(name = "pointQuestion")
    // private int pointQuestion;

    // @Column(name = "indice", length = 100)
    // private String indice;

    // @Column(name = "pointIndice")
    // private int pointIndice;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="defi")
    private Defi defi;
    
    // private String solution;

    // @OneToMany(mappedBy = "etape")
    // @ElementCollection
    // private List<ChoixPossible> choixPossibles;
    
    public int getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(int numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    
}
