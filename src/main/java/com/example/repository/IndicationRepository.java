package com.example.repository;

import com.example.model.Indication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicationRepository extends JpaRepository<Indication, Long> {
    
}
