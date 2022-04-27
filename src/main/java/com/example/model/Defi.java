package com.example.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name="defis")
public class Defi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String idDefi;

    @Column(name="titre")
    private String titre;

    @Column(name="description")
    private String description;

    @Column(name="datecreation")
    private Timestamp dateCreation;

    @Column(name="auteur")
    @ManyToOne
    private Chami auteur;
    
}
