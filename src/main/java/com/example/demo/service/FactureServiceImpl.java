package com.example.demo.service;

import com.example.demo.dto.FactureDto;
import com.example.demo.entity.Collectivite;
import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;
import com.example.demo.repository.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;

    public List<Facture> getAllFacture(){
        return factureRepository.findAll();
    }

    public Facture getFactureByReference(long reference){
        return factureRepository.findByReference(reference);
    }

    public Facture getFatureById(Long id){
        return factureRepository.getReferenceById(id);
    }

    public Facture createNewFacture(FactureDto factureDto) {
        Facture newFacture = new Facture();
        newFacture.setNom(factureDto.getNom()); // Devrait être newFacture.setNom(factureDto.getNom());
        newFacture.setReference(factureDto.getReference()); // Devrait être newFacture.setReference(factureDto.getReference());
        newFacture.setMontant(factureDto.getMontant()); // Devrait être newFacture.setMontant(factureDto.getMontant());
        return factureRepository.save(newFacture);
    }


    public Facture updateFacture(Long id, FactureDto factureDto) {
        Facture newFacture = factureRepository.findById(id).orElseThrow(null);
        newFacture.setNom(factureDto.getNom());
        newFacture.setMontant(factureDto.getMontant());
        newFacture.setReference(factureDto.getReference());
        newFacture.setDateCreation(factureDto.getDateCreation());
        newFacture.setDateReglement(factureDto.getDateReglement());
        newFacture.setPayerOuNon(factureDto.getPayerOuNon());
        return factureRepository.save(newFacture);
    }



    public void deleteAllFactures() {
        factureRepository.deleteAll();
    }

    public void deleteFacture(Long id){
        factureRepository.deleteById(id);
    }

}
