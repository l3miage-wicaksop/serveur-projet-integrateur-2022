package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="ChoixPossible")
public class ChoixPossible {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idChoix;
    
    // @ManyToOne
    // private Question question;

    @Column(name = "reponsePossible")
    private String choix;
}
