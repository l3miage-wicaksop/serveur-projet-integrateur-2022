package com.example.DTO;

import java.util.List;

import com.example.model.*;

import lombok.Data;

@Data

public class ChamiDTO {

    
    public ChamiDTO(Chami chami) {
        this.login = chami.getLogin();
        this.age = chami.getAge();
        this.description = chami.getDescription();
        this.ville = chami.getVille();
        this.prenom = chami.getPrenom();
        this.nom = chami.getNom();
        // this.defis = chami.getDefis();
        this.visites = chami.getVisites();
    }

    private String login;

    private int age;

    private String description;

    private String ville;

    private String prenom;

    private String nom;

    // private List<Defi> defis;

    private List<Visite> visites;
}
