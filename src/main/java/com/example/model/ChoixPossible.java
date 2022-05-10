package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="ChoixPossible")
public class ChoixPossible {

    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="etape", nullable = false)
    private Etape etape;

    public Etape getEtape() {
        return this.etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    @Id
    @Column(name="idChoix")
    private int idChoix;

    public int getIdChoix() {
        return this.idChoix;
    }

    public void setIdChoix(int idChoix) {
        this.idChoix = idChoix;
    }

    private String choix;

    public String getChoix() {
        return this.choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

}
