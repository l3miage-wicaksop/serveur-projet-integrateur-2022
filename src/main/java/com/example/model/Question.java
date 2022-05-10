package com.example.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    // @Id
    private int numeroEtape;

    private String questionText ;

    @ManyToOne
    @JoinColumn(name="questionEtape", nullable = false)
    @JsonIgnore // je ne sais pas pourquoi ca ne marche pas sans avec
    private Etape etape;
    

    @OneToMany(mappedBy = "question")
    @ElementCollection
    private List<ChoixPossible> choixPossibles;

    private String solution;
    
    private int point;
    
    @OneToOne(optional = true)
    private Indice indice;

}
