package com.example.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="arrets")
public class Arret {
    @Id
    @Column(name="codeArret")
    private String codeArret;

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
    // @JsonManagedReference("arretDefi")
    private List<Defi> defis;

}
