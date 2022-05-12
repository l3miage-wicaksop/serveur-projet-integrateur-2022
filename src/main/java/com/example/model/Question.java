package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idQuestion")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idQuestion")
    @Column(name="idQuestion")
    private Long idQuestion;

    // // @Id
    // @OneToOne(mappedBy = "idEtape")
    // @JoinColumn(name="numeroEtape", nullable = false)
    // private Long numeroEtape;
    @Column(name="questionText")
    private String questionText ;

    
    //@JsonIgnore // je ne sais pas pourquoi ca ne marche pas sans avec
    //private Etape etape;
    

    @OneToMany
    // @LazyCollection(LazyCollectionOption.FALSE)
    // @JoinColumn(name = "choixPossibles")
    private List<ChoixPossible> choixPossibles;


    @Column(name="solution")
    private String solution;
    
    @Column(name = "point")
    private int point;
    
    @OneToOne(optional = true,cascade = CascadeType.ALL)
    @JoinColumn(name="indice")
    private Indice indice;

}
