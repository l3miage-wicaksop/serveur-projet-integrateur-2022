package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;


/* 

Evaluation :
  - Réponse :
      Question : 1
      Réponse :
  - Photo :
      Label : 2
      Image : ../materiels/visite/V151-45-2.png

Commentaire :
  - J'ai mis un temps à capter le rond et les petits.
  - Après je sais pas si vous avez essayé mais pour le selfie c'est coton !
  - J'en ai quand même fait un mais on voit pas les moutons !!!*/
  @Entity
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @Table(name="visites")
  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "idVisite")
public class Visite{
    
    @Id
    @Column(name="id_visite")
    private String idVisite;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="defi")
    // @JsonIgnoreProperties("visites")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Defi defi;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visiteur")
    // @JsonBackReference("visiteur")
    // @JsonIgnoreProperties("visites")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Chami visiteur;
     
    @Column(name = "dateDebut")
    private Timestamp dateDebut;

    @Column(name = "dateFin")
    private Timestamp dateFin;
    
    // true = distanciel
    @Column(name = "modeVisite")
    private boolean modeVisite;

    // on calcul ici QuestionBienRepondu - IndiceUtilisé
    @Column(name = "pointTotal")
    private int pointTotal;

    // fini ou pas fini;
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "temps")
    private int temps;

    @Column(name = "commentaire")
    private String commentaire;
    
    public boolean getModeVisite(){
        return this.modeVisite;
    }
    public boolean getStatus(){
        return this.status;
    }
    

}
