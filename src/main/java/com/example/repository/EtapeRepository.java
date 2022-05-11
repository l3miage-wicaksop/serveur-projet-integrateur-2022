package com.example.repository;

import com.example.model.Chami;
import com.example.model.Defi;
import com.example.model.Etape;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface EtapeRepository extends JpaRepository<Etape, Long> {
    Etape getByIdEtape(Long idEtape);
    List<Etape> getByDefi(Defi defi);
    void deleteByDefi(Defi defi);
        // TODO Auto-generated method s
    //Etape getByDefiAndNumeroEtape(Defi defi, int numeroEtape);
}