package com.example.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="etapes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEtape")
public class Etape {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idEtape")
    @Column(name="idEtape", unique = true, nullable = false)
    private Long idEtape;

    public  Long getIdEtape() {
        return idEtape;
    }
   

    public void setIdEtape( Long idEtape) {
		this.idEtape = idEtape;
	}
    
    @Column(name="description")
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="indication")
    private Indication indication;

    public Indication getIndication() {
        return this.indication;
    }

    public void setIndication(Indication indication) {
        this.indication = indication;
    }

    // @Column(name = "question", length = 1000)
    // private String question;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="question")
    private Question question;

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    };

    // @Column(name = "pointQuestion")
    // private int pointQuestion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="indice")
    private Indice indice;

    public Indice getIndice() {
        return this.indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }

    // @Column(name = "pointIndice")
    // private int pointIndice;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="defi")
    private Defi defi;

    public Defi getDefi() {
        return this.defi;
    }

    public void setDefi(Defi defi) {
        this.defi = defi;
    };

    

    
}
