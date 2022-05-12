package com.example.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nomArret")
@Table(name="arrets")
public class Arret {
    @Id
    @Column(length=40, name="nomArret")
    private String nomArret;

    private String ville;

    @Column(name="openstreetmap", length=80)
    private String openstreetmap;

    @Column(name="googlemap", length=80)
    private String googlemap;

    private Double longitude;

    private Double latitude;

    @OneToMany(mappedBy = "arret")
    @LazyCollection(LazyCollectionOption.FALSE)
    
    
    private List<Defi> defis;

}
