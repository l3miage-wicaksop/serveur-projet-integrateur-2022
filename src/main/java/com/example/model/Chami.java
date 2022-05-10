package com.example.model;

import lombok.*;

import javax.annotation.Nullable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="chamis")
// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "login")
public class Chami {

    // login est le login
    @Id
    @Column(name="login", length=40)
    private String login;

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "age")
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "description", length = 2000)
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="ville")
    private String ville;

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Column(name="prenom")
    private String prenom;

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name="nom")
    private String nom;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


    @Nullable
    @Column(name="pointTotal")
    private int pointTotal;

    public int getPointTotal() {
        return this.pointTotal;
    }

    public void setPointTotal(int pointTotal) {
        this.pointTotal = pointTotal;
    }

    @OneToMany(mappedBy = "auteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    // @JsonManagedReference("auteurDefi")
    // @JsonIgnoreProperties("auteur") // to avoid bidirectionnal infinite loop
    private List<Defi> defis;

    public List<Defi> getDefis() {
        return this.defis;
    }

    public void setDefis(List<Defi> defis) {
        this.defis = defis;
    }

    @OneToMany(mappedBy = "visiteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    // @JsonManagedReference("visiteur")
    // @JsonIgnoreProperties("visiteur")// to avoid bidirectionnal infinite loop
    private List<Visite> visites;

    public List<Visite> getVisites() {
        return this.visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }
    
    
   
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + login + "]";
    }



  

    
}
