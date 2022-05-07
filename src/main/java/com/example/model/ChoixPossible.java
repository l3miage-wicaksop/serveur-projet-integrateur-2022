package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="etape")
    private Etape etape;

    @Id
    @Column(name="idChoix")
    private int idChoix;

    private String choix;
}
