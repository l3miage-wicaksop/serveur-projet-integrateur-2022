package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Indice  {
    @Id
    @GeneratedValue
    private int idIndice;

    @Column(name="point")
    private int point;

    @Column(name="indice",length = 1000)
    private String indice;

    public int getIdIndice() {
        return this.idIndice;
    }

    public void setIdIndice(int idIndice) {
        this.idIndice = idIndice;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getIndice() {
        return this.indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    

}
