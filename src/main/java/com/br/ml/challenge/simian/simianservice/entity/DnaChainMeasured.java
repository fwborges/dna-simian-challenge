package com.br.ml.challenge.simian.simianservice.entity;

import java.util.List;

public class DnaChainMeasured {

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
