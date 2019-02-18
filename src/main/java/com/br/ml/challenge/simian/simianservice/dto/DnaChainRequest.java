package com.br.ml.challenge.simian.simianservice.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DnaChainRequest {

    @NotNull
    @NotEmpty(message = "DNA is required")
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
