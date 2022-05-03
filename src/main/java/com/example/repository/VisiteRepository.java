package com.example.repository;

import com.example.model.Defi;
import com.example.model.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VisiteRepository extends JpaRepository <Visite, String> {
    
  Visite getByIdVisite(String idVisite);
  List<Visite> findVisiteByIdVisiteContaining(String defiIdWithoutD);
  List<Visite> findByIdVisiteContains(String defiIdWithoutD);
  List<Visite> findByIdVisiteIsContaining(String defiIdWithoutD);
  List<Visite> findByDefi(Defi d);

}
