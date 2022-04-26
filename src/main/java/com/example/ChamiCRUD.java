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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
                u.userId = rs.getString("userId");
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


    @PostMapping("/{userId}")
    Chami create(@PathVariable(value="userId") String id, @RequestBody Chami c, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("insert into chamis (userId, description, login, age) values('" + id + "','"+ c.description + "', '" + c.login + "'," + c.age + ")" ); 

            return c;
            
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

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM chamis where userId ='" + id +"'"); 
            Chami c = new Chami(); 
            while (rs.next()) { 
                
                c.login = rs.getString("login"); 
                c.age = rs.getInt("age"); 
                c.description = rs.getString("age");
                c.userId = id;
            }
            
            
            return c;
            
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

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("update Chamis set age = " + c.age + ", login = '" + c.login + "',  description = '" + c.description + "' where userid = '" + id+"';"); 
            
            return c;
            
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
            ResultSet rs = stmt.executeQuery("delete from Chamis where userId = '" + id + "';"); 
            
            
            
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
