package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idIndice")
public class Indice  {
    @Id
    @GeneratedValue
    private int idIndice;

    private int point;
    
    private String indice;

    @ManyToOne
    @JoinColumn(nullable = false)
    Etape indiceEtape;

    @OneToOne(optional = true)
    Question question;
    
    

}
