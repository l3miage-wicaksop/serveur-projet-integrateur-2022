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
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
// @ToString
@Table(name="defis")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDefi")

public class Defi {

  
    @Id
    @Column(name="iddefi")
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    // @GeneratedValue()
    private String idDefi;

    @Column(name="titre")
    private String titre;

    @Column(name="typeDefi")
    @Enumerated(EnumType.STRING)
    private TypeDefi typeDefi;

    // equivalent à varchar(2000)
    @Column(name="description", length=2000)
    private String description;

    @Column(name="datecreation")
    private Timestamp dateCreation;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="auteur")
    // @JsonBackReference("auteurDefi")
    // @JsonIgnoreProperties("defis")
    private Chami auteur;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="arret")
    // @JsonBackReference(value="arretDefi")
    // @JsonIgnoreProperties("defi")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private Arret arret;

    @OneToMany(mappedBy = "defi")
    @JsonIgnoreProperties("defi")
    // @JsonIgnoreProperties(ignoreUnknown = true)
    private List<Visite> visites;

    @Embedded
    @OneToMany(mappedBy = "defi")
    private List<Etape> etapes;

    private String tmpArret;
    
}
