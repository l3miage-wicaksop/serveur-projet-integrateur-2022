package com.example.model;



import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question extends Etape {
    @Column(name="sujet")
    private String sujet;

    public String getSujet() {
        return this.sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    } ;

    @ElementCollection
    @CollectionTable(
        name = "choixPossibles",
        joinColumns=@JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    )
    @OneToMany
    @JoinColumn(name="choix")
    private List<ChoixPossible> choixPossibles;
    private String solution;
    private int point;

    public List<ChoixPossible> getChoixPossibles() {
        return this.choixPossibles;
    }

    public void setChoixPossibles(List<ChoixPossible> choixPossibles) {
        this.choixPossibles = choixPossibles;
    }

    public String getSolution() {
        return this.solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    

}
