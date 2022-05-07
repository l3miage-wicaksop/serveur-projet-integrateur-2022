package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Indice  {
    @Id
    @GeneratedValue
    private int idIndice;
    private int point;
    
    private String indice;

    

}
