    package com.example.demo.dto;

    import com.example.demo.entity.Facture;
    import lombok.Data;

    import java.math.BigDecimal;
    import java.sql.Timestamp;
    import java.util.ArrayList;
    import java.util.List;

    @Data
    public class FactureDto {

        private String nom;

        private BigDecimal montant;
        private long reference;

        private Timestamp dateCreation;

        private Timestamp dateReglement;

        private Boolean payerOuNon;

        private List<Facture> listFacture;

        public List<Facture> getAllFacture() {
            List<Facture> list = new ArrayList<>();
            list.addAll(listFacture);
            return list;
        }
    }
