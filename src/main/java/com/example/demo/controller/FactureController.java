package com.example.demo.controller;

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.FactureMapper;
import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public ResponseEntity<List<FactureDto>> getAllFacture(){
        List<Facture> factures = factureService.getAllFacture();
        System.out.println(factures.size());
        List<FactureDto> factureDtoList = FactureMapper.INSTANCE.facturesToListFactureDtos(factures);
        System.out.println(factureDtoList.size());
        return new ResponseEntity<>(factureDtoList, HttpStatus.OK);
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<Facture> getFactureByReference(@PathVariable long reference) {
        Facture facture = factureService.getFactureByReference(reference);
        return new ResponseEntity<>(facture, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        Facture facture = factureService.getFatureById(id);
        return new ResponseEntity<>(facture, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Facture> createdFacture(@RequestBody FactureDto factureDto){
        Facture savedFacture = factureService.createNewFacture(factureDto);
        return new ResponseEntity<>(savedFacture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody FactureDto factureDto) {
        System.out.println("Je met à jour facture : "+factureDto);
        Facture updatedFacture = factureService.updateFacture(id, factureDto);
        System.out.println("Je met à jour facture : "+updatedFacture);
        return new ResponseEntity<>(updatedFacture, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllFactures() {
        factureService.deleteAllFactures();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
