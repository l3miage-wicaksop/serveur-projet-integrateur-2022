package com.example.repository;

import com.example.model.Indice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface IndiceRepository {
    Indice getByIdEtape(Long idEtape);
}