package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
// @ToString
@Table(name="defis")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDefi")

public class Defi {

  
    @Id
    @Column(name="idDefi")
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    // @GeneratedValue()
    private String idDefi;

    public String getIdDefi() {
        return this.idDefi;
    }

    public void setIdDefi(String idDefi) {
        this.idDefi = idDefi;
    }

    @Column(name="titre")
    private String titre;

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Column(name="typeDefi")
    private String typeDefi;

    public String getTypeDefi() {
        return this.typeDefi;
    }

    public void setTypeDefi(String typeDefi) {
        this.typeDefi = typeDefi;
    }

    // equivalent à varchar(2000)
    @Column(name="description", length=2000)
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="datecreation")
    private Timestamp dateCreation;

    public Timestamp getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name="points")
    private int points;

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="auteur")
    // @JsonBackReference("auteurDefi")
    // @JsonIgnoreProperties("defis")
    private Chami auteur;

    public Chami getAuteur() {
        return this.auteur;
    }

    public void setAuteur(Chami auteur) {
        this.auteur = auteur;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="arret")
    // @JsonBackReference(value="arretDefi")
    // @JsonIgnoreProperties("defi")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Arret arret;

    public Arret getArret() {
        return this.arret;
    }

    public void setArret(Arret arret) {
        this.arret = arret;
    }

    @OneToMany(mappedBy = "defi")
    @JsonIgnoreProperties("defi")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private List<Visite> visites;

    public List<Visite> getVisites() {
        return this.visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }
    
    @OneToMany(mappedBy = "defi")
    private List<Etape> etapes;

    public List<Etape> getEtapes() {
        return this.etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public List<Question> getAllQuestions(){
        List<Question> listQ=new ArrayList<Question>();
        for (int i=0;i<this.etapes.size();i++){
            listQ.add(this.etapes.get(i).getQuestion());
        }
        return listQ;
    }
    
}
