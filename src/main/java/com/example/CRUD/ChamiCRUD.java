package com.example.CRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.Chami;

import com.example.repository.ChamiRepository;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/chamis")
public class ChamiCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ChamiRepository chamiRepository;

    @GetMapping("/")
    public List<Chami> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            List<Chami> chamis = chamiRepository.findAll();
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
    Chami create(@RequestBody Chami c, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {

            Chami newChami = Chami.builder()
                    .age(c.getAge())
                    .description(c.getDescription())
                    .login(c.getLogin())
                    .ville(c.getVille())
                    .prenom(c.getPrenom())
                    .nom(c.getNom())
                    .pointTotal(0)
                    .build();

            chamiRepository.save(newChami);

            return newChami;
            
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
    Chami read(@PathVariable(value="userId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            
            Chami chami = chamiRepository.getBylogin(id);
            return chami;
            
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
    Chami update(@PathVariable(value="userId") String id, @RequestBody Chami c, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Chami changedChami = Chami.builder()
                    .login(id)
                    .description(c.getDescription())
                    .age(c.getAge())
                    .prenom(c.getPrenom())
                    .nom(c.getNom())
                    .ville(c.getVille())
                    .pointTotal(c.getPointTotal())
                    .build();

            chamiRepository.save(changedChami);
            return changedChami;
            
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

            chamiRepository.deleteById(id);
            
            
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
