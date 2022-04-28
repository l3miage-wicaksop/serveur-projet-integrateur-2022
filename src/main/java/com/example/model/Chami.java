package com.example.model;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="chamis")
public class Chami {

    // userId est le login
    @Id
    @Column(name="userID")
    private String userId;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "auteur")
    @JsonIgnoreProperties("auteur") // to avoid bidirectionnal infinite loop
    private List<Defi> defis;

    @OneToMany(mappedBy = "visiteur")
    @JsonIgnoreProperties("visiteur") // to avoid bidirectionnal infinite loop
    private List<Visite> visites;
    
    
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + userId + "]";
    }

    
}
