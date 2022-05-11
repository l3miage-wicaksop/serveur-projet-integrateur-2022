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
            if (eta.getDefi() == null || eta.getDefi() == null) {
                // response.sendError(404, "defi ne doit pas etre null");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");

            }
            Defi defi = defiRepository.getByIdDefi(eta.getDefi().getIdDefi());

            // Etape etape = Etape.builder()
            //         .defi(defi)
            //         .numeroEtape(eta.getNumeroEtape())
            //         .indication(eta.getIndication())
                    
            //         .build();

            Etape etape = new Etape();
            etape.setDefi(defi);
            etape.setQuestion(eta.getQuestion());
            etape.setIndication(eta.getIndication());
            //etape.setIndice(eta.getIndice());
            //indicationRepository.save(eta.getIndice());
            Question q=eta.getQuestion();
            Indice i=q.getIndice();
            indiceRepository.save(i);
            //.setIndice(eta.getQuestion().getIndice())
            questionRepository.save(eta.getQuestion());
            // Question newQuestion = Question.builder()
            //         .idQuestion(eta.getQuestion().getIdQuestion())
            //         .point(eta.getQuestion().getPoint())
            //         .
            //         .build();

            etape.setQuestion(eta.getQuestion());
            //Indice indice = eta.getIndice();
            //Indice i=new Indice();
            List<Etape> etapes=new ArrayList<Etape>();
            etapes.add(etape);
            //defi.setEtapes(etapes);
           // defiRepository.save(defi);
            // etape.setIndication(eta.getIndication());
            

            // etape.setQuestion();
            // etape.setIndication(new ArrayList<Indication>());

            // etapeRepository.saveAndFlush(etape);

            // Etape etapeFromServer = etapeRepository.findById(etape.getIdEtape()).get();
            // int idxChoix = 0;
            // int idxQuestion = 0;
            // int idxIndication = 0;s
            // List<Question> newQuestionList = new ArrayList<Question>();
            // List<ChoixPossible> newChoixList = new ArrayList<ChoixPossible>();
            // List<Indication> newIndicationList = new ArrayList<Indication>();

            // ajoute questions (if exist)
            // if (eta.getQuestions() != null) {
            // for (Question question : eta.getQuestions()) {
            // Question q = Question.builder()
            // .questionText(question.getQuestionText())
            // .solution(question.getSolution())
            // .point(question.getPoint())

            // // .idQuestion("Q"+Integer.toString(idxQuestion) +
            // // "-E"+Integer.toString(eta.getNumeroEtape()))
            // .build();
            // q.setChoixPossibles(new ArrayList<ChoixPossible>());
            // q.setEtape(etape);
            // etape.getQuestions().add(q);
            // newQuestionList.add(q);

            // idxQuestion++;

            // // ajoute choix possibles (if exist)
            // if (question.getChoixPossibles() != null) {
            // for (ChoixPossible choix : question.getChoixPossibles()) {
            // ChoixPossible c = ChoixPossible.builder()
            // .choix(choix.getChoix())
            // .idChoix(idxChoix)
            // .build();

            // q.getChoixPossibles().add(c);
            // c.setQuestion(question);
            // idxChoix++;

            // newChoixList.add(c);
            // }
            // }
            // }
            // }

            // // ajout indication (if exist)
            // if (eta.getIndication() != null) {
            // for (Indication indication : eta.getIndication()) {
            // Indication newIndication = Indication.builder()
            // .indicationText(indication.getIndicationText())
            // .build();

            // newIndication.setIndicationEtape(etape);
            // etape.getIndication().add(indication);
            // newIndicationList.add(newIndication);
            // }
            // }


            // Question question = eta.getQuestion();
            // Question q = new Question();
            // q.setNumeroEtape(question.getNumeroEtape());
            // q.setSolution(question.getSolution());
            // q.setPoint(question.getPoint());
            // q.setQuestionText(question.getQuestionText());
            // q.setChoixPossibles(new ArrayList<ChoixPossible>());
            // q.setEtape(etape);

            
            // if (question.getChoixPossibles() != null) {
            //     for (ChoixPossible choix : question.getChoixPossibles()) {
                    
            //         ChoixPossible c = new ChoixPossible();
            //         c.setChoix(choix.getChoix());
            //         c.setQuestion(q);
                    
            //         choixPossibleRepository.save(c);
            //     }
            // }
            // // newQuestionsList.add(q);
            // //etapeRepository.save(etape);
            // etape.setQuestion(q);
            // etape.setIndice(indice);
            // 
            etapeRepository.save(etape);
            // etape.setQuestions(newQuestionList);
            // etape.setIndication(newIndicationList);
            // questionRepository.saveAll(newQuestionList);
            // choixPossibleRepository.saveAll(newChoixList);
            // indicationRepository.saveAll(newIndicationList);
            // etapeRepository.save(etape);
            return etape;
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
