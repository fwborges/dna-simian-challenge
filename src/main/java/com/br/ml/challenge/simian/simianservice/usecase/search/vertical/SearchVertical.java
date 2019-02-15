package com.br.ml.challenge.simian.simianservice.usecase.search.vertical;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;

@UseCase
public class SearchVertical {

    private SearchResponse searchResponse = new SearchResponse();

    public SearchResponse execute(String[][] matrixDNA) {

        for(int i = 0; i < matrixDNA.length; i++) {
            for(int j = 0; j < matrixDNA.length; j++) {

                verifyDNA(matrixDNA[j][i]);
                System.out.println(searchResponse.toString());
            }
        }

        return searchResponse;
    }

    private void verifyDNA(String type) {

        switch (type) {

            case "A": {
                searchResponse.incrementChainA();
                searchResponse.closeChainingAAsPossible();
                break;
            }
            case "C": {
                searchResponse.incrementChainC();
                searchResponse.closeChainingCAsPossible();
                break;
            }
            case "G": {
                searchResponse.incrementChainG();
                searchResponse.closeChainingGAsPossible();
                break;
            }
            case "T": {
                searchResponse.incrementChainT();
                searchResponse.closeChainingTAsPossible();
                break;
            }
        }
    }
}
