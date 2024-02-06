package com.example.demo;

import com.example.demo.dto.FactureDto;
import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;
import com.example.demo.repository.FactureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class DemoApplicationTests {

	@InjectMocks
	FactureService factureService;

	@Mock
	FactureRepository factureRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void voirSiLapplicationSeLance(){
		System.out.println("Le programme se lance");
	}

	@Test
	void createFacture() {
		List<Facture> factures = new ArrayList<>();

		// Simuler le comportement de factureRepository.save()
		when(factureRepository.save(any(Facture.class))).thenAnswer(invocation -> {
			Facture facture = invocation.getArgument(0);
			factures.add(facture);
			return facture;
		});

		// Créer x factures
		int nmbreFactureCreate = 10;
		for (int i = 0; i <nmbreFactureCreate; i++) {
			factureService.createNewFacture(new FactureDto());
		}

		// Vérifier que createNewFacture a été appelé x fois
		verify(factureRepository, times(nmbreFactureCreate)).save(any(Facture.class));

		// Vérifier que la taille de la liste factures est de x
		assert factures.size() == nmbreFactureCreate;

		// Afficher les factures créées
		for (int i = 0; i < factures.size(); i++) {
			System.out.println("Affichage de la facture créée numéro " + i + " = " + factures.get(i));
		}
		System.out.println("Nombre total de factures : " + factures.size());
	}

}
