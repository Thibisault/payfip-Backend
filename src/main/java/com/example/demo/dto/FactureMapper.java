package com.example.demo.dto;
import com.example.demo.dto.FactureDto;

import com.example.demo.entity.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FactureMapper {
    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);

    FactureDto factureToFactureDto(Facture facture);

    List<FactureDto> facturesToListFactureDtos(List<Facture> factures); // Correction ici
}
