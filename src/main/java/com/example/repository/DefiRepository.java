package com.example.repository;

import com.example.model.Chami;
import com.example.model.Defi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface DefiRepository extends JpaRepository<Defi, String> {

}