package com.example.mapper;

import com.example.DTO.ChamiDTO;
import com.example.model.Chami;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChamiMapper {
    ChamiDTO toDTO(Chami chami);
}
