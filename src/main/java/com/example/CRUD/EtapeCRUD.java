package com.example.CRUD;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.ChoixPossible;
import com.example.model.Defi;
import com.example.model.Etape;
import com.example.repository.ChoixPossibleRepository;
import com.example.repository.DefiRepository;
import com.example.repository.EtapeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/etapes")
public class EtapeCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    EtapeRepository etapeRepository;

    @Autowired
    DefiRepository defiRepository;

    @Autowired
    ChoixPossibleRepository choixPossibleRepository;

    @GetMapping("/")
    public List<Etape> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            List<Etape> etapes = etapeRepository.findAll();
            return etapes;
        } catch(Exception e){
                response.setStatus(500);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                return null;
        }   
    }


    @PostMapping("/")
    Etape create(@RequestBody Etape eta, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            if(eta.getDefi() == null || eta.getDefi() == null){
                // response.sendError(404, "defi ne doit pas etre null");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
          
            }
            // Defi defi = defiRepository.findById(eta.getDefi().getIdDefi()).get();
            
            Etape etape = Etape.builder()
            .numeroEtape(eta.getNumeroEtape())
            .indication(eta.getIndication())
            .indice(eta.getIndice())
            .pointIndice(eta.getPointIndice())
            .question(eta.getQuestion())
            .pointQuestion(eta.getPointQuestion())
            .solution(eta.getSolution())
            .build();

            etapeRepository.save(etape);

            int idxChoix = 0;
            for(ChoixPossible choix: eta.getChoixPossibles()){
                ChoixPossible c = ChoixPossible.builder()
                .etape(etape)
                .choix(choix.getChoix())
                .etape(choix.getEtape())
                .idChoix(idxChoix)
                .build();

                idxChoix++;

                choixPossibleRepository.save(c);
            }

            return etape;
        } catch(Exception e){
                response.setStatus(500);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                return null;
        }   
    }

    

}
