package com.example.repository;

import com.example.model.Chami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ChamiRepository extends JpaRepository<Chami, String> {
    Chami getBylogin(String login);
}