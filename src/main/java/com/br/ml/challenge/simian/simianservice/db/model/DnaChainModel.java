package com.br.ml.challenge.simian.simianservice.db.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chains")
public class DnaChainModel {

    private List<String> dna;

    private Boolean simian;

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }

    public Boolean getSimian() {
        return simian;
    }

    public void setSimian(Boolean simian) {
        this.simian = simian;
    }
}
