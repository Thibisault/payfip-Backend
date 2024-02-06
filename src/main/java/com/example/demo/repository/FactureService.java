package com.example.demo.repository;

import com.example.demo.dto.FactureDto;
import com.example.demo.entity.Facture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {

    public List<Facture> getAllFacture();

    public Facture getFactureByReference(long reference);

    public Facture getFatureById(Long id);

    public Facture createNewFacture(FactureDto factureDto);

    public Facture updateFacture(Long id, FactureDto factureDto);

    public void deleteAllFactures();

    public void deleteFacture(Long id);

}
