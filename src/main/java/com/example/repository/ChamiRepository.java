package com.example.repository;

import com.example.model.Chami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface ChamiRepository extends JpaRepository<Chami, String> {
    Chami getBylogin(String login);
}