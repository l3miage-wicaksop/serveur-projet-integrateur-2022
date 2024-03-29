package com.example.model;

import lombok.*;

import javax.annotation.Nullable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="chamis")
// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "login")
public class Chami {

    // login est le login
    @Id
    @Column(name="login", length=40)
    private String login;

    @Column(name = "age")
    private int age;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name="ville")
    private String ville;

    @Column(name="prenom")
    private String prenom;

    @Column(name="nom")
    private String nom;

    @Nullable
    @Column(name="pointTotal")
    private int pointTotal;

    // @OneToMany(mappedBy = "auteur")
    // @LazyCollection(LazyCollectionOption.FALSE)
    // // @JsonManagedReference("auteurDefi")
    // // @JsonIgnoreProperties("auteur") // to avoid bidirectionnal infinite loop
    // private List<Defi> defis;

    @OneToMany(mappedBy = "visiteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    // @JsonManagedReference("visiteur")
    // @JsonIgnoreProperties("visiteur")// to avoid bidirectionnal infinite loop
    private List<Visite> visites;
    
    
   
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + login + "]";
    }

    
}
