package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Visite  {
    
   

    @Id
    @Column(name="id_visite")
    private String idVisite;
    
    
    @Column(name = "date")
    private Timestamp date;
    
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "temps")
    private int temps;

    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visiteur")
    @JsonIgnoreProperties("visites")
    private Chami visiteur;
    

}
