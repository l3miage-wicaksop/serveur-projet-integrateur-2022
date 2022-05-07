package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Embeddable
@Table(name="etapes")
public class Etape {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idEtape")
    @Column(name="idEtape", unique = true, nullable = false)
    private  Long idEtape;
    
    @Column(name="numeroEtape")
    private int numeroEtape; 

    @Column(name="indication", length = 1000)
    private String indication;

    @Column(name = "question", length = 1000)
    private String question;

    @Column(name = "pointQuestion")
    private int pointQuestion;

    @Column(name = "indice", length = 100)
    private String indice;

    @Column(name = "pointIndice")
    private int pointIndice;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="iddefi")
    private Defi defi;
    
    private String solution;

    @OneToMany
    @JoinColumn(name="choix")
    private List<ChoixPossible> choixPossibles;
    
    public int getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(int numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    
}
