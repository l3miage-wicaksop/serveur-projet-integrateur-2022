package com.example.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NoArgsConstructor
@AllArgsConstructor
// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nomArret")
@Table(name="arrets")
public class Arret {
    @Id
    @Column(length=40, name="nomArret")
    private String nomArret;

    private String ville;

    public String getNomArret() {
        return this.nomArret;
    }

    public void setNomArret(String nomArret) {
        this.nomArret = nomArret;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Column(name="openstreetmap", length=80)
    private String openstreetmap;

    public String getOpenstreetmap() {
        return this.openstreetmap;
    }

    public void setOpenstreetmap(String openstreetmap) {
        this.openstreetmap = openstreetmap;
    }

    @Column(name="googlemap", length=80)
    private String googlemap;

    private Double longitude;

    private Double latitude;

    public String getGooglemap() {
        return this.googlemap;
    }

    public void setGooglemap(String googlemap) {
        this.googlemap = googlemap;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @OneToMany(mappedBy = "arret")
    @LazyCollection(LazyCollectionOption.FALSE)
    
    
    private List<Defi> defis;

    public List<Defi> getDefis() {
        return this.defis;
    }

    public void setDefis(List<Defi> defis) {
        this.defis = defis;
    }

}
