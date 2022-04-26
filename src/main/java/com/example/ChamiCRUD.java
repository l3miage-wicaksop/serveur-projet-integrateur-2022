package com.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamiCRUD {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public ArrayList<Chami> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM chamis"); 
            ArrayList<Chami> L = new ArrayList<Chami>(); 
           
            while (rs.next()) { 
                Chami u = new Chami(); 
                u.login = rs.getString("login"); 
                u.age = rs.getInt("age"); 
                u.description = rs.getString("description");
                L.add(u); 
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
}
