package com.br.ml.challenge.simian.simianservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chains")
public class DnaChain {

    private List<String> dna;

    private Boolean simian;

    public void setDna(List<String> dna) {
        this.dna = dna;
    }

    public void setSimian(Boolean simian) {
        this.simian = simian;
    }

    public Boolean isSimian() {

        return simian;
    }
}
