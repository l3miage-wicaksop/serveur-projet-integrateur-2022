package com.example.svc;

import javax.transaction.Transactional;

import com.example.model.Chami;
import com.example.repository.ChamiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChamiService {
    private ChamiRepository chamiRepository;

    @Autowired
    public ChamiService(ChamiRepository chamiRepository) {
        this.chamiRepository = chamiRepository;
    }

    public Chami findByLogin(String login){
        return chamiRepository.findById(login).get();
    }

    
}
