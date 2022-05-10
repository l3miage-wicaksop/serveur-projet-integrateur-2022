package com.example.CRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.model.Arret;
import com.example.model.Chami;
import com.example.model.Defi;
import com.example.repository.ArretRepository;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/defis")
public class DefiCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private DefiRepository defiRepository;

    @Autowired
    private ChamiRepository chamiRepository;

    @Autowired
    private ArretRepository arretRepository;

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
            
            Defi changedDefi = new Defi();
            changedDefi.setIdDefi(id);
            changedDefi.setArret(d.getArret());
            changedDefi.setDescription(d.getDescription());
            changedDefi.setAuteur(d.getAuteur());
            changedDefi.setTitre(d.getTitre());
            changedDefi.setDateCreation(d.getDateCreation());
            changedDefi.setTypeDefi(d.getTypeDefi());
            
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

    @PostMapping("/")
    Defi create( @RequestBody Defi c, HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {  
            //JSON to send to check
            // {
            //     "titre": "test",
            //     "description":"juste pour un test de POST",
            //     "auteur": {
            //         "login":"escribis",
            //         "age":22,
            //         "description": "vlalavlavl",
            //         "ville":"Grenoble"
            //     },
            //     "dateCreation":"2022-04-26T16:18:25.000+00:00"
            // }
            
            //Find Chami for Defi creation
            Chami chamiAuteur = chamiRepository.findById(c.getAuteur().getLogin()).get();

            //Find Arret for Defi creation
            Arret arretDefi = arretRepository.findByNomArret(c.getArret().getNomArret());
            
            
            //Generate a next Id for Defi
            String newDefiId ="";
            List<Defi> defis = defiRepository.findAll();
            if(defis.isEmpty()){
                newDefiId = "D1";
            }else{

                String lastDefiId = defis.get(defis.size()-1).getIdDefi();
                int defiIdInt = Integer.parseInt(lastDefiId.substring(lastDefiId.indexOf("D") + 1)) +1;
                newDefiId = "D" + defiIdInt;
            }

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());


            Defi newDefi = new Defi();
            newDefi.setIdDefi(newDefiId);
            newDefi.setArret(arretDefi);
            newDefi.setDescription(c.getDescription());
            newDefi.setAuteur(chamiAuteur);
            newDefi.setTitre(c.getTitre());
            newDefi.setDateCreation(currentTime);
            newDefi.setTypeDefi(c.getTypeDefi());
            


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
