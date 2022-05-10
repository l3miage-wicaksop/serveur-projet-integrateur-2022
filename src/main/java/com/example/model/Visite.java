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
  @NoArgsConstructor
  @AllArgsConstructor
  @Table(name="visites")
  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "idVisite")
public class Visite{
    
    @Id
    @Column(name="idVisite")
    private String idVisite;

    public String getIdVisite() {
        return this.idVisite;
    }

    public void setIdVisite(String idVisite) {
        this.idVisite = idVisite;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="defi")
    // @JsonIgnoreProperties("visites")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Defi defi;

    public Defi getDefi() {
        return this.defi;
    }

    public void setDefi(Defi defi) {
        this.defi = defi;
    };
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="chami")
    // @JsonBackReference("visiteur")
    // @JsonIgnoreProperties("visites")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Chami visiteur;

    public Chami getVisiteur() {
        return this.visiteur;
    }

    public void setVisiteur(Chami visiteur) {
        this.visiteur = visiteur;
    }
     
    @Column(name = "dateDebut")
    private Timestamp dateDebut;

    public Timestamp getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Column(name = "dateFin")
    private Timestamp dateFin;

    public Timestamp getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }
    
    // true = distanciel
    @Column(name = "mode")
    private boolean mode;

    public boolean isMode() {
        return this.mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    // on calcul ici QuestionBienRepondu - IndiceUtilisé
    @Column(name = "score")
    private int score;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // fini ou pas fini;
    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Column(name = "temps")
    private int temps;

    public int getTemps() {
        return this.temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    @Column(name = "commentaire")
    private String commentaire;

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    public boolean getMode(){
        return this.mode;
    }
    public boolean getStatus(){
        return this.status;
    }
    

}
