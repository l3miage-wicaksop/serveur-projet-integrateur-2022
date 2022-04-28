package com.example;
import java.sql.Timestamp;
import com.example.model.Chami;
import com.example.model.Defi;
import com.example.repository.ChamiRepository;
import com.example.repository.DefiRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ObjectBuilder {
    @Autowired
    ChamiRepository chamiRepository;

    @Autowired
    DefiRepository defiRepository;

    public void V0ChamisCreator(){
        Chami c1 = Chami.builder().userId("carobis").age(21).build();
        Chami c2 = Chami.builder().userId("escribis").age(43).build();
        Chami c3 = Chami.builder().userId("momo").age(38).build();
        Chami c4 = Chami.builder().userId("nomoldu").age(20).build();
        Chami c5 = Chami.builder().userId("python38").age(18).build();
        Chami c6 = Chami.builder().userId("yes4moldus").age(38).build();

        chamiRepository.save(c1);
        chamiRepository.save(c2);
        chamiRepository.save(c3);
        chamiRepository.save(c4);
        chamiRepository.save(c5);
        chamiRepository.save(c6);
    }

    public void V0DefisCreator(){
        
        String str1 = "15/03/2021 16:03";
        Timestamp timestamp1 = Timestamp.valueOf(str1);  
        
        String descriptionD1 = "";
        descriptionD1 += "- Rendez vous à l'arrêt de bus \"Maison du tourisme - Hubert Dubedout\".\n ";
        descriptionD1 += "- Cherche ce qu'il faut pour faire un méchoui.\n ";
        
        Defi d1 = Defi.builder()
            .idDefi("D127")
            .titre("Le Méchoui")
            .auteur(chamiRepository.getByUserId("carobis"))
            .description(descriptionD1)
            .dateCreation(timestamp1)
            .build();
        

        String str2 = "01/04/2021 15:03";
        Timestamp timestamp2 = Timestamp.valueOf(str2);  
        
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
            .auteur(chamiRepository.getByUserId("escribis"))
            .description(descriptionD2)
            .dateCreation(timestamp2)
            .build();

        String str3 = "13/04/2021 12:03";
        Timestamp timestamp3 = Timestamp.valueOf(str3);
        
        String descriptionD3 ="";
        descriptionD3 += "- Rendez-vous à l'arrêt Victor Hugo\n";
        descriptionD3 += "- Il tourne en rond pour le plaisir des petits. Cherche le.\n";
        descriptionD3 += "- Si il n'y est pas demande à quelqu'un où il est quand il y est :-) \n";
        descriptionD3 += "- Fait toi un selfie avec les 2 moutons en utilisant ton sens de la créativité.\n";
        descriptionD3 += "- Si tu n'y arrives pas demande à quelqu'un qu'il/elle te tire un portrait.\n";
    
        Defi d3 = Defi.builder()
            .idDefi("D151")
            .titre("Ils tournent et rond.")
            .auteur(chamiRepository.getByUserId("escribis"))
            .description(descriptionD3)
            .dateCreation(timestamp3)
            .build();
        
        String str4 = "17/03/2021 12:03";
        Timestamp timestamp4 = Timestamp.valueOf(str4);
                
        String descriptionD4 ="";
        descriptionD4 += "- Rendez-vous à l'arrêt Victor-Hugo\n";
        descriptionD4 += "- C'est l'été. Tu as besoin de grand air.\n";
        descriptionD4 += "- Demande à quelqu'un où est la maison de la montagne.\n";
        descriptionD4 += "- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.\n";
        descriptionD4 += "- Vas pas trop vite ! Les chamoix sont en plein centre ville ! \n";
        descriptionD4 += "- Grenoble c'est la ville du béton, mais c'est aussi la capitale des Alpes.\n";
        descriptionD4 += "- Fait attention tu pourrais te faire écraser par des pachidermes ! \n";
        descriptionD4 += "- (Q1) Combien d'écureuils (compter uniquement les tout plats) ?\n";
        descriptionD4 += "- (Q2) Combien de chamois ?\n";
        descriptionD4 += "- (Q3) Combien d'éléphants ?\n";
    
        Defi d4 = Defi.builder()
            .idDefi("D189")
            .titre("Et l'écureil alors ?")
            .auteur(chamiRepository.getByUserId("carobis"))
            .description(descriptionD4)
            .dateCreation(timestamp4)
            .build();
    
        defiRepository.save(d1);
        defiRepository.save(d2);
        defiRepository.save(d3);
        defiRepository.save(d4);
    
    
    }
}