package com.example.demo.dto;

import com.example.demo.entity.Collectivite;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CollectiviteDto {

    private int codeCol;

    private List<Collectivite> listCollectivite;

    public List<Collectivite> getAllCollectivite() {
        List<Collectivite> list = new ArrayList<>();
        list.addAll(listCollectivite);
        return list;
    }

}
