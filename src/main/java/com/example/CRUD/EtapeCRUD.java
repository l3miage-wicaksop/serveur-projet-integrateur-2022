package com.example.CRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.ChoixPossible;
import com.example.model.Defi;
import com.example.model.Etape;
import com.example.model.Indication;
import com.example.model.Indice;
import com.example.model.Question;
import com.example.repository.ChoixPossibleRepository;
import com.example.repository.DefiRepository;
import com.example.repository.EtapeRepository;
import com.example.repository.IndicationRepository;
import com.example.repository.IndiceRepository;
import com.example.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    IndicationRepository indicationRepository;

    @Autowired
    IndiceRepository indiceRepository;

    @GetMapping("/")
    public List<Etape> allUsers(HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            List<Etape> etapes = etapeRepository.findAll();
            return etapes;
        } catch (Exception e) {
            response.setStatus(500);
            try {
                response.getOutputStream().print(e.getMessage());
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
            System.err.println(e.getMessage());
            return null;
        }
    }

    

    @GetMapping("/defi")
    public List<Etape> getByDefi(@RequestParam String idDefi,HttpServletResponse reponse){
        Defi defi = defiRepository.getByIdDefi(idDefi);
        List<Etape> etapes = etapeRepository.getByDefi(defi);

        return etapes;
    }

    // @GetMapping("/defi/etape")
    // public Etape getByDefiAndNumeroEtape(@RequestParam String idDefi, @RequestParam int numeroEtape, HttpServletResponse reponse){
    //     Defi defi = defiRepository.getByIdDefi(idDefi);
    //     // List<Etape> etapes = etapeRepository.getByDefi(defi);
    //     Etape etape = etapeRepository.getByDefiAndNumeroEtape(defi, numeroEtape);

    //     return etape;
    // }

    // @PostMapping("{idEtape}/indication/")
    // Indication ajouteIndication(@PathVariable(value = "idEtape") Long id, @RequestBody Indication indication, HttpServletResponse reponse) throws SQLException {
        
    //     try (Connection connection = dataSource.getConnection()) {
    //         Etape etapeFromServer = etapeRepository.getById(id);
    //         Indication newIndication = new Indication();
    //         newIndication.setIndicationEtape(etapeFromServer);
    //         newIndication.setIndicationText(indication.getIndicationText());
            
    //         indicationRepository.save(newIndication);
            
    //         return newIndication;
    //     }
    
    // }


    // @PostMapping("{idEtape}/question/")
    // Question ajouteQuestion(@PathVariable(value = "idEtape") Long id, @RequestBody Question question,
    //         HttpServletResponse reponse) throws SQLException {
    //     List<Question> newQuestionsList = new ArrayList<Question>();
    //     try (Connection connection = dataSource.getConnection()) {
    //         Etape etapeFromServer = etapeRepository.getById(id);
    //         // for (Question question : questions) {
    //             Question q = new Question();
    //             //q.setNumeroEtape(question.getNumeroEtape());
    //             q.setSolution(question.getSolution());
    //             q.setPoint(question.getPoint());
    //             q.setQuestionText(question.getQuestionText());
    //             q.setChoixPossibles(new ArrayList<ChoixPossible>());
    //             //q.setNumeroEtape(etapeFromServer.getIdEtape());
    //             newQuestionsList.add(q);
    //             questionRepository.save(q);


    //             if (question.getChoixPossibles() != null) {
    //                 for (ChoixPossible choix : question.getChoixPossibles()) {

    //                     ChoixPossible c = new ChoixPossible();
    //                     c.setChoix(choix.getChoix());
    //                     c.setQuestion(q);
    
    //                     choixPossibleRepository.save(c);
    //                 }
    //             }
    //         // }
    //         return q;

    //     }

        

    // }

    @PostMapping("/")
    Etape create(@RequestBody Etape eta, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            if (eta.getDefi() == null) {
                // response.sendError(404, "defi ne doit pas etre null");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");

            }
            Defi defi = defiRepository.getByIdDefi(eta.getDefi().getIdDefi());

            Etape newEtape = Etape.builder()
                .defi(defi)
                .indication(eta.getIndication())
                .question(eta.getQuestion())
                .build();
            
            // Etape etape = new Etape();
            // etape.setDefi(defi);
            // etape.setQuestion(eta.getQuestion());
            // etape.setIndication(eta.getIndication());
            
            Question q=eta.getQuestion();
            List<ChoixPossible> choices = q.getChoixPossibles();
            Indice i=q.getIndice();
            choixPossibleRepository.saveAll(choices);
            indiceRepository.save(i);
            questionRepository.save(eta.getQuestion());

            
            etapeRepository.save(newEtape);
            
            return newEtape;

        } catch (Exception e) {
            response.setStatus(500);
            try {
                response.getOutputStream().print(e.getMessage());
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
            System.err.println(e.getMessage());
            return null;
        }
    }

}
