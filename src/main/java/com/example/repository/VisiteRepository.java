package com.example.repository;

import com.example.model.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface VisiteRepository extends JpaRepository <Visite, String> {
    
  Visite getByVisteId(String visiteID);

}
