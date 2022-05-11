package com.example.repository;

import com.example.model.Chami;
import com.example.model.Defi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface DefiRepository extends JpaRepository<Defi, String> {
    // Defi getByUserId(String idDefi);
    Defi getByIdDefi(String idDefi);
}