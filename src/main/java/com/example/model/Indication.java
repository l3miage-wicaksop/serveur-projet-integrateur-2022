package com.example.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="indications")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idIndication")
public class Indication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idIndication")
    private int IdIndication;

    @OneToOne(mappedBy = "indication")
    @JoinColumn(name="indicationEtape")
    private Etape indicationEtape;

    @Column(name="indication", length = 2000)
    private String indicationText;

}
