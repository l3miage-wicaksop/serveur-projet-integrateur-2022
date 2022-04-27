package com.example;

import com.example.model.Chami;
import com.example.model.Defi;

public class ObjectBuilder {
    
    public void V0ChamisCreator(){
        Chami c1 = Chami.builder().login("carobis").age(21).build();
        Chami c2 = Chami.builder().login("escribis").age(43).build();
        Chami c3 = Chami.builder().login("momo").age(38).build();
        Chami c4 = Chami.builder().login("nomoldu").age(20).build();
        Chami c5 = Chami.builder().login("python38").age(18).build();
        Chami c6 = Chami.builder().login("yes4moldus").age(38).build();
    }

    public void V0DefisCreator(){
        Defi d1 = Defi.builder()
            .idDefi("D127")
            .titre("Le Méchoui")
            .auteur("carobis")
            .description("- Rendez-vous à l''arrêt Victor-Hugo\n- C''est l''été. Tu as besoin de grand air.\n- Demande à quelqu''un où est la maison de la montagne.\n- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.\n- Vas pas trop vite ! Les chamoix sont en plein centre ville !\n- Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.\n- Fait attention tu pourrais te faire écraser par des pachidermes !\n- (Q1) Combien d''écureuils (compter uniquement les tout plats) ?\n- (Q2) Combien de chamois ?\n- (Q3) Combien d''éléphants ?")
            .build();
        

        String descriptionD2 = "";
        descriptionD2 += "- Rendez vous à l'arrêt de bus \"Grenoble - hôtel de ville\".\n";
        descriptionD2 += "- Passe par \"l'orangerie\".\n";
        descriptionD2 += "- Ca te donneras de l'énergie mais surtout ne dépasse pas les bornes !\n";
        descriptionD2 += "- Fatiguée ? T'as pas fait des bornes. Tu devrais avoir de l'énergie.\n";
        descriptionD2 += "- Reste sur le parking pour te recharger les piles.\n";
        descriptionD2 += "- Cherche plutôt celui qui pourrait te donner matière à te protéger pendant l'hiver.\n";
        descriptionD2 += "- Il est là. Il te regarde de haut. Il t'observe.\n";
        descriptionD2 += "- Il bêle. \"Je suis ceux que je suis. Et le vert, je le mange !\"";
        descriptionD2 += "- Combien de boucles sous mon cou ?\n";


        Defi d2 = Defi.builder()
            .idDefi("D145")
            .titre("Le vert, je le mange !")
            .auteur("escribis")
            .description(descriptionD2)
            .build();
    }

}
