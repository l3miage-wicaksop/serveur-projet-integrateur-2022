package com.example.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.Defi;
import com.example.model.Visite;
import com.example.repository.DefiRepository;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/visites")
public class VisiteCRUD {
        @Autowired
        private DataSource dataSource;
    
        @Autowired
        private VisiteRepository visiteRepository;

        @Autowired
        private DefiRepository defiRepository;
    
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
    
        @PostMapping("/")
        Visite create(@RequestBody Visite v, HttpServletResponse response) {
            try (Connection connection = dataSource.getConnection()) {
                
                String newVisiteId = "";
                String defiIdWithoutD = ((Defi) v.getDefi()).getIdDefi().substring(((Defi) v.getDefi()).getIdDefi().indexOf("D") + 1);
                //Find all visites
                // List<Visite> visites = visiteRepository.findVisiteByIdVisiteContaining(defiIdWithoutD);
                // List<Visite> visites = visiteRepository.findVisiteByIdVisiteContaining(defiIdWithoutD);
                Defi d = defiRepository.findById(((Defi) v.getDefi()).getIdDefi()).get();
                List<Visite> visitesDefiD = visiteRepository.findByDefi(d);
                
                if(visitesDefiD.size()==0){
                    //VisiteId construction
                    newVisiteId = "V" + defiIdWithoutD + "-" + "1";
                }
                else{
                    int newVisiteSerie = visitesDefiD.size() +1;
                    newVisiteId = "V" + defiIdWithoutD + "-" + Integer.toString(visitesDefiD.size()+1);
                    //Take defiId for visite id construction
                    // int defiIdInt = Integer.parseInt(defiIdWithoutD);
                    //Take last visite id
                    // String lastVisiteId = visites.get(visites.size()-1).getIdVisite();
                    //Incremented visite id after "="
                    // int visiteIdInt = Integer.parseInt(lastVisiteId.substring(lastVisiteId.indexOf("-") + 1)) +1;
                    //VisiteId construction
                    // newVisiteId = "V" + defiIdInt + "-" + visiteIdInt;
                }


                Visite newVisite = new Visite();
                newVisite.setIdVisite(newVisiteId);
                newVisite.setVisiteur(v.getVisiteur());
                newVisite.setDefi(v.getDefi());
                newVisite.setDateDebut(v.getDateDebut());
                newVisite.setDateFin(v.getDateFin());
                newVisite.setMode(v.getMode());
                newVisite.setScore(v.getScore());
                newVisite.setStatus(v.getStatus());
                newVisite.setTemps(v.getTemps());
                newVisite.setCommentaire(v.getCommentaire());
                
    
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
                Visite visite = visiteRepository.getByIdVisite(id);
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
    
                Visite changedVisite = new Visite();
                changedVisite.setIdVisite(id);
                changedVisite.setVisiteur(v.getVisiteur());
                changedVisite.setDefi(v.getDefi());
                changedVisite.setDateDebut(v.getDateDebut());
                changedVisite.setDateFin(v.getDateFin());
                changedVisite.setMode(v.getMode());
                changedVisite.setScore(v.getScore());
                changedVisite.setStatus(v.getStatus());
                changedVisite.setTemps(v.getTemps());
                changedVisite.setCommentaire(v.getCommentaire());
                
                        
    
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

