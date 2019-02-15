package com.br.ml.challenge.simian.simianservice.usecase.dna;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class VerifyDNA {

    public void execute(String type) {

        SearchResponse searchResponse = new SearchResponse();

        switch (type) {

            case "A": {
                searchResponse.incrementChainA();
                searchResponse.closeChainingAAsPossible();
            }
            case "C": {
                searchResponse.incrementChainC();
                searchResponse.closeChainingCAsPossible();
            }
            case "G": {
                searchResponse.incrementChainG();
                searchResponse.closeChainingGAsPossible();
            }
            case "T": {
                searchResponse.incrementChainT();
                searchResponse.closeChainingTAsPossible();
            }
            default: {
                searchResponse.resetAll();
            }
        }


     /*   if (cell == 'A') {

            A++;
            T = 0;
            C = 0;
            G = 0;

            if (A == 4) {
                A = 0;
                countingA++;
            }

        }

        if (s.equals("T")) {
            T++;
            A = 0;
            C = 0;
            G = 0;

            if (T == 4) {
                T = 0;
                countingT++;
            }


        }

        if (s.equals("C")) {
            C++;
            A = 0;
            T = 0;
            G = 0;

            if (C == 4) {
                C = 0;
                countingC++;
            }

        }

        if (s.equals("G")) {

            G++;
            C = 0;
            A = 0;
            T = 0;

            if (G == 4) {
                G = 0;
                countingG++;
            }

        } */
    }

}
