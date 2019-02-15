package com.br.ml.challenge.simian.simianservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResearchStatus {

    @JsonProperty("count_mutant_dna")
    private Double countMutantDna;

    @JsonProperty("count_human_dna")
    private Double countHumanDna;

    private Double ratio;

    public Double getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Double countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Double getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Double countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
