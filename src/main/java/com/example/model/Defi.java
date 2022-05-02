package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
// @ToString
@Table(name="defis")
public class Defi {

    @Id
    @Column(name="iddefi")
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    // @GeneratedValue()
    private String idDefi;

    @Column(name="titre")
    private String titre;

    // equivalent à varchar(2000)
    @Column(name="description", length=2000)
    private String description;

    @Column(name="datecreation")
    private Timestamp dateCreation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="auteur")
    // @JsonBackReference("auteurDefi")
    @JsonIgnoreProperties("defis")
    private Chami auteur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="arret")
    // @JsonBackReference(value="arretDefi")
    @JsonIgnoreProperties("defis")
    private Arret arret;

    private String tmpArret;
    
}
