package com.example.CRUD;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.sql.Connection;
import com.example.model.Arret;
import com.example.model.Defi;
import com.example.model.Question;
import com.example.repository.ArretRepository;
import com.example.repository.DefiRepository;

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
@RequestMapping("/api/questions")

public class QuestionCRUD {
    @Autowired
    private DataSource dataSource;

    // @Autowired
    // private ChamiRepository chamiRepository;
    @Autowired
    private DefiRepository defiRepository;

    @GetMapping("/")
    public List<List<Question>> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            List<Defi> defis=defiRepository.findAll();
            List<List<Question>> allQuestions= new ArrayList<List<Question>>();
            for (int i=0;i<defis.size();i++){
                allQuestions.add(defis.get(i).getAllQuestions());
            }
           // List<Question> questions = defiRepository.findAll();
            return allQuestions;
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
