package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Question extends Etape {
    
    private String question ;
    @ElementCollection
    @Column(name="responses")
    private List<String> reponses;
    // private String reponses;
    private String solution;
    private int point;
    

}
