package com.example.model;

import java.util.List;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Question extends Etape {
    
    private String question ;
    private List<String> reponses;
    private String solution;
    private int point;
    

}
