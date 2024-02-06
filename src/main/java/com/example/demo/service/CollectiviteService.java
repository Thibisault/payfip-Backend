package com.example.demo.service;

import com.example.demo.dto.CollectiviteDto;
import com.example.demo.entity.Collectivite;
import com.example.demo.repository.CollectiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectiviteService {

    @Autowired
    CollectiviteRepository collectiviteRepository;

    public Collectivite createNewCollectivite(){
        return collectiviteRepository.save(new Collectivite());
    }

    public List<Collectivite> getAllCollectivite(){
        return collectiviteRepository.findAll();
    }

    public Collectivite getCollectiviteByCodeCol(int codeCol){
        return collectiviteRepository.findByCodeCol(codeCol);
    }
    public Collectivite getFatureById(Long id){
        return collectiviteRepository.getReferenceById(id);
    }

    public Collectivite createNewCollectivite(CollectiviteDto collectiviteDto) {
        Collectivite collectivite = new Collectivite();
        collectivite.setCodeCol(collectiviteDto.getCodeCol());
        return collectiviteRepository.save(collectivite);
    }

    public Collectivite updateCollectivite(Long id, CollectiviteDto collectiviteDto) {
        Collectivite collectivite = collectiviteRepository.findById(id)
                .orElseThrow(null);
        collectivite.setCodeCol(collectiviteDto.getCodeCol());
        return collectiviteRepository.save(collectivite);
    }

    public void deleteAllCollectivite() {
        collectiviteRepository.deleteAll();
    }

    public void deleteCollectivite(Long id){
        collectiviteRepository.deleteById(id);
    }

}
