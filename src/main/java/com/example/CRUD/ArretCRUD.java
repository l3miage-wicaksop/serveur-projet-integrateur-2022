package com.example.CRUD;

import java.util.List;

import javax.sql.DataSource;
import java.sql.Connection;
import com.example.model.Arret;
import com.example.repository.ArretRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/arrets")
public class ArretCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ArretRepository arretRepository;

    @GetMapping("/")
    public List<Arret> allArrets(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            List<Arret> arrets = arretRepository.findAll();
            return arrets;
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
    Arret create(@RequestBody Arret a, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            // link example: https://www.google.com/maps/@45.1878932,5.7240524,19z
            String generatedGoogleMap = "https://www.google.com/maps/@" + a.getLatitude().toString() + "," + a.getLongitude().toString()+ ",19z";

            // link example: https://www.openstreetmap.org/#map=19/45.1856/5.7240524
            String generatedOpenstreetMap = "https://www.openstreetmap.org/#map=19/" + a.getLatitude().toString() + "/" + a.getLongitude().toString();

            Arret newArret = new Arret();
                newArret.setNomArret(a.getNomArret());
                newArret.setLatitude(a.getLatitude());
                newArret.setLongitude(a.getLongitude());
                newArret.setVille(a.getVille());
                newArret.setGooglemap(a.getGooglemap());
                newArret.setOpenstreetmap(a.getOpenstreetmap());

            arretRepository.save(newArret);

            return newArret;
            
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

    @PostMapping("/list/")
    List<Arret> createList(@RequestBody List<Arret> arrets, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            for(Arret arret: arrets){
                this.create(arret, response);
            }

            return arrets;
            
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

    @GetMapping("/{arretId}")
    Arret read(@PathVariable(value="arretId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            
            Arret arret = arretRepository.getById(id);
            return arret;
            
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

    @DeleteMapping("/{arretId}")
    void delete(@PathVariable(value="arretId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            arretRepository.deleteById(id);
            
            
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
