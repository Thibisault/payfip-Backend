package com.example.demo.repository;

import com.example.demo.entity.Collectivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectiviteRepository extends JpaRepository<Collectivite, Long> {
    Collectivite findByCodeCol(int codeCol);
}
