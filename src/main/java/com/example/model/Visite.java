package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/* 

Evaluation :
  - Réponse :
      Question : 1
      Réponse :
  - Photo :
      Label : 2
      Image : ../materiels/visite/V151-45-2.png

Commentaire :
  - J'ai mis un temps à capter le rond et les petits.
  - Après je sais pas si vous avez essayé mais pour le selfie c'est coton !
  - J'en ai quand même fait un mais on voit pas les moutons !!!*/
public class Visite{
    
    @Id
    @Column(name="id_visite")
    private String idVisite;

    @Column(name="id_defi")
    private String idDefi;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visiteur")
    private Chami visiteur;
     
    @Column(name = "date_de_visite")
    private Timestamp dateDeVisite;
    
    @Column(name = "mode")
    private boolean mode;

    @Column(name = "points")
    private int points;

    @Column(name = "score")
    private int score;

    @Column(name = "status")
    private boolean status;
    
    @Column(name = "temps")
    private int temps;

    @Column(name = "indices")
    private int indices;

    @Column(name = "commentaire")
    private String commentaire;
    
    public boolean getMode(){
        return this.mode;
    }
    public boolean getStatus(){
        return this.status;
    }
    

}
