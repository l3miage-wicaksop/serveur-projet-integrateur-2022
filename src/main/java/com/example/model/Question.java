package com.example.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Question extends Etape {
    
    private String question ;

    // @ElementCollection
    // @CollectionTable(
    //     name = "choixPossibles",
    //     joinColumns=@JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    // )
    @OneToMany
    @JoinColumn(name="choix")
    private List<ChoixPossible> choixPossibles;

    private String solution;
    
    private int point;
    

}
