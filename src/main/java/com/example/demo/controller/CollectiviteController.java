package com.example.demo.controller;

import com.example.demo.dto.CollectiviteDto;
import com.example.demo.entity.Collectivite;
import com.example.demo.service.CollectiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/collectivites")
public class CollectiviteController {

    @Autowired
    private CollectiviteService collectiviteService;

    @GetMapping
    public ResponseEntity<List<Collectivite>> getAllCollectivite(){
        CollectiviteDto collectiviteDto = new CollectiviteDto();
        collectiviteDto.setListCollectivite(collectiviteService.getAllCollectivite());
        return new ResponseEntity<>(collectiviteDto.getAllCollectivite(), HttpStatus.OK);
    }

    @GetMapping("/code/{codeCol}")
    public ResponseEntity<Collectivite> getCollectiviteByCodeCol(@PathVariable int codeCol) {
        System.out.println(codeCol);
        Collectivite collectivite = collectiviteService.getCollectiviteByCodeCol(codeCol);
        System.out.println(collectivite);
        System.out.println(collectivite.getCodeCol());
        return new ResponseEntity<>(collectivite, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collectivite> getCollectiviteById(@PathVariable Long id) {
        Collectivite collectivite = collectiviteService.getFatureById(id);
        return new ResponseEntity<>(collectivite, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Collectivite> createdCollectivite(@RequestBody CollectiviteDto collectiviteDto){
        Collectivite savedCollectivite = collectiviteService.createNewCollectivite(collectiviteDto);
        return new ResponseEntity<>(savedCollectivite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collectivite> updateCollectivite(@PathVariable Long id, @RequestBody CollectiviteDto collectiviteDto) {
        Collectivite updatedCollectivite = collectiviteService.updateCollectivite(id, collectiviteDto);
        return new ResponseEntity<>(updatedCollectivite, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllCollectivites() {
        collectiviteService.deleteAllCollectivite();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCollectivite(@PathVariable Long id) {
        collectiviteService.deleteCollectivite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
