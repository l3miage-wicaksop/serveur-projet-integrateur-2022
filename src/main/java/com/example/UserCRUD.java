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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserCRUD {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public ArrayList<User> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM users"); 
            ArrayList<User> L = new ArrayList<User>(); 
           
            while (rs.next()) { 
                User u = new User(); 
                u.login = rs.getString("login"); 
                u.age = rs.getInt("age"); 
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

    User read(@PathVariable(value="userId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM users where userId =" + id); 
            
            
            User u = new User(); 
            u.login = rs.getString("login"); 
            u.age = rs.getInt("age"); 
            
            return u;
            
        } catch(Exception e){
            response.setStatus(502);
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
    User create(@PathVariable(value="userId") String id, @RequestBody User u, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) { 

            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("insert into users (userId, description, login, age) values('" + id+ "','"+ u.description + "', '" + u.login + "'," + u.age + ")" ); 

            u.userId = rs.getString("userId");
            u.login = rs.getString("login");
            u.description = rs.getString("description");
            u.age = rs.getInt("age");
            
            return u;
            
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


    


    
}
