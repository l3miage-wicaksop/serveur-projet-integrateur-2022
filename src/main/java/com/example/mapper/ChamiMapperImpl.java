package com.example.mapper;

import com.example.DTO.ChamiDTO;
import com.example.model.Chami;

public class ChamiMapperImpl implements ChamiMapper {
    @Override
    public ChamiDTO toDTO(Chami chami){
        if(chami == null){
            return null;
        }

        ChamiDTO chamiDTO = new ChamiDTO(chami);
        
        return chamiDTO;
    }
}
