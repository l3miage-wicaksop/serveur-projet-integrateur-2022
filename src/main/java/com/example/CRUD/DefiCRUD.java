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
import com.example.model.Defi;
import com.example.repository.ChamiRepository;
import com.example.repository.DefiRepository;
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
@RequestMapping("/api/defis")
public class DefiCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private DefiRepository defiRepository;

    @Autowired
    private ChamiRepository chamiRepository;

    @GetMapping("/")
    public List<Defi> allUsers(HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {

            List<Defi> defis = defiRepository.findAll();

            return defis;
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


    @GetMapping("/{idDefi}")
    Defi read(@PathVariable(value="idDefi") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) {
            Defi defi = defiRepository.getByIdDefi(id);
            return defi;
            
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

    @PutMapping("/{idDefi}")
    Defi update(@PathVariable(value="idDefi") String id, @RequestBody Defi d, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 
            
            Defi changedDefi = Defi.builder()
                    .idDefi(id)
                    .description(d.getDescription())
                    .auteur(d.getAuteur())
                    .titre(d.getTitre())
                    .dateCreation(d.getDateCreation())
                    .build();

            defiRepository.save(changedDefi);
            return changedDefi;
            
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

    @PostMapping("/{idDefi}")
    Defi create(@PathVariable(value="idDefi") String id, @RequestBody Defi c, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            
            //Find Chami for Defi creation
            // Chami chamiAuteur = chamiRepository.getByUserId(c.getAuteur().getUserId());
            Defi newDefi = new Defi();
            newDefi.setDateCreation(c.getDateCreation());
            newDefi.setDescription(c.getDescription());
            newDefi.setTitre(c.getTitre());
            newDefi.setIdDefi(id);
            Chami chamiAuteur = chamiRepository.getById(c.getAuteur().getLogin());
            newDefi.setAuteur(chamiAuteur);

            //Generate a next Id for Defi
            List<Defi> defis = defiRepository.findAll();
            String lastDefiId = defis.get(defis.size()-1).getIdDefi();
            int defiIdInt = Integer.parseInt(lastDefiId.substring(lastDefiId.indexOf("D") + 1)) +1;
            String newDefiId = "D" + defiIdInt;

            

            // Defi newDefi = Defi.builder()
            //         .idDefi(id)
            //         .auteur(chamiAuteur)
            //         .dateCreation(c.getDateCreation())
            //         .description(c.getDescription())
            //         .build();

            defiRepository.save(newDefi);

            return newDefi;

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

    @DeleteMapping("/{idDefi}")
    void delete(@PathVariable(value="idDefi") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()) { 
            defiRepository.deleteById(id);
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
