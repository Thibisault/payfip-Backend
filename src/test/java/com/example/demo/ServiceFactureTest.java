package com.example.demo;

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.FactureMapper;
import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ServiceFactureTest {

    @Autowired
    FactureService factureService;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllFactureTest(){
        System.out.println(factureService.getAllFacture());
        System.out.println(factureService.getAllFacture().size());
    }

    @Test
    void deleteAllFacture(){
        System.out.println("Avant création d'une nouvelle facture : " + factureService.getAllFacture().size());
        factureService.createNewFacture(new FactureDto());
        System.out.println("Avant suppression : " + factureService.getAllFacture().size());
        factureService.deleteAllFactures();
        System.out.println("Après suppression : " + factureService.getAllFacture().size());

    }

    @Test
    public void shouldMapCarToDto() {
        //Given
        String nom = "Morris";
        BigDecimal montant = (BigDecimal.valueOf(6));
        long ref = 15;

        Facture facture = new Facture();
        facture.setNom(nom);
        facture.setMontant(montant);
        facture.setReference(ref);

        //when
        FactureDto factureDto = FactureMapper.INSTANCE.factureToFactureDto( facture );

        //then
        assertThat( factureDto ).isNotNull();
        assertThat( factureDto.getNom() ).isEqualTo( nom );
        assertThat( factureDto.getMontant() ).isEqualTo( montant );
        assertThat( factureDto.getReference() ).isEqualTo( ref );
    }

}
