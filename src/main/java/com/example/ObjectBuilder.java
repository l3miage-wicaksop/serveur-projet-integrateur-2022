package com.example;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Chami;
import com.example.model.ChoixPossible;
import com.example.model.Defi;
import com.example.model.Etape;
import com.example.model.Indication;
import com.example.model.Indice;
import com.example.model.Question;
import com.example.model.Visite;
import com.example.repository.ChamiRepository;
import com.example.repository.DefiRepository;
import com.example.repository.VisiteRepository;

import org.springframework.beans.factory.annotation.Autowired;



public class ObjectBuilder {
    @Autowired
    ChamiRepository chamiRepository;

    @Autowired
    DefiRepository defiRepository;

    @Autowired
    VisiteRepository visiteRepository;

    public void V0ChamisCreator(){
        Chami c1 = new Chami();
        //Chami.builder().login("carobis").age(21).build();
        c1.setLogin("carobis");
        c1.setAge(21);
        
        Chami c2 = new Chami();
        //Chami.builder().login("carobis").age(21).build();
        c1.setLogin("chenah");
        c1.setAge(21);
      

        Chami c3 = new Chami();
        //Chami.builder().login("carobis").age(21).build();
        c1.setLogin("PDIORI");
        c1.setAge(21);
      

        Chami c4 = new Chami();
        //Chami.builder().login("carobis").age(21).build();
        c1.setLogin("suk");
        c1.setAge(21);
      


        chamiRepository.save(c1);
        chamiRepository.save(c2);
        chamiRepository.save(c3);
        chamiRepository.save(c4);
    }

    public void V0DefisCreator(){
        
        String str1 = "15/03/2021 16:03";
        Timestamp timestamp1 = Timestamp.valueOf(str1);  
        
        String descriptionD1 = "";
        descriptionD1 += "- Rendez vous à l'arrêt de bus \"Maison du tourisme - Hubert Dubedout\".\n ";
        descriptionD1 += "- Cherche ce qu'il faut pour faire un méchoui.\n ";
        
        Defi d1 = new Defi();
        d1.setIdDefi("D127");
        d1.setTitre("Le Méchoui");
        d1.setAuteur(chamiRepository.getBylogin("carobis"));
        d1.setDescription(descriptionD1);
        d1.setDateCreation(timestamp1);
        
        Etape e1=new Etape();
        e1.setDefi(d1);
        e1.setDescription("D127 E1 description");
        int i=1;
        //first way.
        Long l2=Long.valueOf(i);//second way.
        e1.setIdEtape(l2);

        Question q1=new Question();
        q1.setSujet(descriptionD1);
        ChoixPossible ch=new ChoixPossible();
        List<ChoixPossible> listCh=new ArrayList<ChoixPossible>();
        ch.setEtape(e1);
        ch.setChoix(descriptionD1);
        ch.setIdChoix(1);

        ChoixPossible ch2=new ChoixPossible();
        ch2.setEtape(e1);
        ch2.setChoix("wrong");
        ch2.setIdChoix(2);

        listCh.add(ch);
        listCh.add(ch2);

        Indication indic=new Indication();
        indic.setText("Indicatio nhere");
        indic.setSrcVideo("srcVideo here");

        q1.setChoixPossibles(listCh);
        q1.setPoint(23);
        q1.setSolution(descriptionD1);

        Indice indice=new Indice();
        indice.setIdIndice(1);
        indice.setIndice("clue here");
        indice.setPoint(1);

        q1.setIndice(indice);
        e1.setIndication(indic);
        e1.setQuestion(q1);



       
    
        defiRepository.save(d1);
      
    
    
    }

    public void V0VisitesCreator(){

        String str = "10/04/2021 18:00";
        Timestamp timestamp = Timestamp.valueOf(str);
        
        String commentaire ="";
        commentaire += "- Il pleuvait des cordes. Je me suis mis du mauvais coté de l'arrêt.\n";
        commentaire += "- J'ai pris le premier indice.\n";
        commentaire += "- Après évidemment de l'autre coté c'est plus facile.\n";
        commentaire += "- En fait je trouve qu'il est un peu trop facile => j'ai mis 3 étoiles.\n";

        Defi d = defiRepository.findById("D127").get();
        
        // Visite v1 = Visite.builder()
        //     .defi(d)
        //     .idVisite("V127-1")
        //     .visiteur(chamiRepository.getBylogin("nomoldus"))
        //     // .dateDeVisite(timestamp)
        //     .modeVisite(true)
        //     .points(0)
        //     .score(3)
        //     .status(true)
        //     .temps(8)
        //     .commentaire(commentaire)
        //     .build();

            
        //     visiteRepository.save(v1);

    
    
    
    }

}