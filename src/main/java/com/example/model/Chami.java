package com.example.model;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Chami {

    // login est le login
    @Id
    @Column(name="login")
    private String login;

    @Column(name = "age")
    private int age;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name="ville")
    private String ville;

    @OneToMany(mappedBy = "auteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    //@JsonIgnoreProperties("auteur") // to avoid bidirectionnal infinite loop
    private List<Defi> defis;

    @OneToMany(mappedBy = "visiteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    //@JsonIgnoreProperties("visiteur") // to avoid bidirectionnal infinite loop
    private List<Visite> visites;
    
    
   
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + login + "]";
    }

    
}
