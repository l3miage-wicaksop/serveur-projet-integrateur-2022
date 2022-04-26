package com.example;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
@CrossOrigin
@RequestMapping("/api/defis")
public class DefiCRUD {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public ArrayList<Defi> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM defis"); 
            ArrayList<Defi> L = new ArrayList<Defi>(); 
           
            while (rs.next()) { 
                Defi d = new Defi(); 
                d.idDefi = rs.getString("idDefi"); 
                d.titre = rs.getString("titre");
                d.description = rs.getString("description");
                d.dateCreation = rs.getTimestamp("dateCreation");
                d.auteur = rs.getString("auteur");
                
                L.add(d); 
            }
            return L;
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
    Defi create(@PathVariable(value="userId") String id, @RequestBody Defi d, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("insert into defis  (idDefi, titre, dateCreation, auteur, description)  values('" + id + "','"+ d.titre + "', '" + new Date(System.currentTimeMillis()) + "','" + d.auteur + "','"+d.description+ "')" ); 

            return d;
            
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
    Defi read(@PathVariable(value="userId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM defis where idDefi ='" + id +"'"); 
            Defi d = new Defi(); 
            while (rs.next()) { 
                d.idDefi = id;
                d.auteur = rs.getString("auteur");
                d.description = rs.getString("description");
                d.titre = rs.getString("titre");
                d.dateCreation = rs.getTimestamp("dateCreation");
                
            }
            
            
            return d;
            
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

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("delete from Defis where idDefi = '" + id + "';"); 
            
            
            
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
