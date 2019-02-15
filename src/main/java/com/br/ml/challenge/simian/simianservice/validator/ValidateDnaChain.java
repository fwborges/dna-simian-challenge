package com.br.ml.challenge.simian.simianservice.validator;

import java.util.Arrays;

public class ValidateDnaChain {

    public void execute(String[] dnaChain) {

        int length = dnaChain.length;

        Arrays.stream(dnaChain).forEach(dna -> {

                    if(dna.length() != length) {
                        throw new RuntimeException("Matriz não é quadrada");
                    }

                    if(!dna.matches("//([ACGT])//g")) {
                        throw new RuntimeException("Matriz contem valores não permitidos");
                    }

                });


    }
}
