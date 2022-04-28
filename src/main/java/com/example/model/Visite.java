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
    private String idViste;
    
    
    
    private Timestamp date;
    private boolean status;
    private int temps;

    private String commentaire;

    @Id

}
