package com.example.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.Visite;

import com.example.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/chamis")
public class VisiteCRUD {

        @Autowired
        private DataSource dataSource;
    
        @Autowired
        private VisiteRepository visiteRepository;
    
        @GetMapping("/")
        public List<Visite> allUsers(HttpServletResponse response){
            try (Connection connection = dataSource.getConnection()) {
                List<Visite> chamis = visiteRepository.findAll();
                return chamis;
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
    
    
        @PostMapping("/{userId}")
        Visite create(@PathVariable(value="userId") String id, @RequestBody Visite v, HttpServletResponse response) {
            try (Connection connection = dataSource.getConnection()) {
                
                String newVisiteId = "";
                //Find all visites
                List<Visite> visites = visiteRepository.findAll();

                if(visites.size()==0){
                    //VisiteId construction
                    int visiteIdIntByDefi = Integer.parseInt(v.getIdDefi().substring(v.getIdDefi().indexOf("D") + 1)) +1;
                    newVisiteId = "V" + visiteIdIntByDefi + "-" + "1";
                }
                else{
                    //Take last visite id
                    String lastVisiteId = visites.get(visites.size()-1).getIdVisite();
                    //Incremented visite id after "="
                    int visiteIdInt = Integer.parseInt(lastVisiteId.substring(lastVisiteId.indexOf("-") + 1)) +1;
                    //Take defiId for visite id construction
                    int visiteIdIntByDefi = Integer.parseInt(v.getIdDefi().substring(v.getIdDefi().indexOf("D") + 1)) +1;
                    //VisiteId construction
                    newVisiteId = "V" + visiteIdIntByDefi + "-" + visiteIdInt;
                }
                

                /*
                JSON for verification
                {

                }
                */


                Visite newVisite = Visite.builder()
                        .idVisite(newVisiteId)
                        .visiteur(v.getVisiteur())
                        .idDefi(v.getIdDefi())
                        .dateDeVisite(v.getDateDeVisite())
                        .mode(v.getMode())
                        .points(v.getPoints())
                        .score(v.getScore())
                        .status(v.getStatus())
                        .temps(v.getTemps())
                        .commentaire(v.getCommentaire())
                        .build();
    
                visiteRepository.save(newVisite);
    
                return newVisite;
                
            } catch(Exception e){
                response.setStatus(404);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                return null;
            }
        }
    
        @GetMapping("/{userId}")
        Visite read(@PathVariable(value="userId") String id, HttpServletResponse response){
            try (Connection connection = dataSource.getConnection()) {
                Visite visite = visiteRepository.getById(id);
                return visite;
                
            } catch(Exception e){
                response.setStatus(404);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                return null;
            }
        }
    
        @PutMapping("/{userId}")
        Visite update(@PathVariable(value="userId") String id, @RequestBody Visite v, HttpServletResponse response){
            try (Connection connection = dataSource.getConnection()) { 
    
                Visite changedVisite = Visite.builder()
                .idVisite(v.getIdVisite())
                .visiteur(v.getVisiteur())
                .dateDeVisite(v.getDateDeVisite())
                .mode(v.getMode())
                .points(v.getPoints())
                .score(v.getScore())
                .status(v.getStatus())
                .temps(v.getTemps())
                .commentaire(v.getCommentaire())
                .build();
                        
    
                visiteRepository.save(changedVisite);
                return changedVisite;
                
            } catch(Exception e){
                response.setStatus(404);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                return null;
            }
        }
    
        @DeleteMapping("/{userId}")
        void delete(@PathVariable(value="userId") String id, HttpServletResponse response){
            try (Connection connection = dataSource.getConnection()) { 
    
                visiteRepository.deleteById(id);
                
                
            } catch(Exception e){
                response.setStatus(404);
                try{
                    response.getOutputStream().print(e.getMessage());
                } catch(Exception e2){
                    System.err.println(e2.getMessage());
                }
                System.err.println(e.getMessage());
                
            }
    
        }
    
}

