package com.example.model;

import javax.persistence.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Indice extends Etape {
    private int point;
    private String indice;

    

}
