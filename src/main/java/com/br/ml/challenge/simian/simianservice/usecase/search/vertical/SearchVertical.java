package com.br.ml.challenge.simian.simianservice.usecase.search.vertical;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.entity.DNAType;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;

@UseCase
public class SearchVertical {

    public SearchResponse execute(String[][] matrixDNA) {

        SearchResponse searchResponse = new SearchResponse();

        for(int j = 0; j < matrixDNA.length; j++) {

            searchResponse.resetAll();

            for(int i = 0; i < matrixDNA.length; i++) {

                verifyDNA(matrixDNA[i][j], searchResponse);
            }
        }

        return searchResponse;
    }

    private void verifyDNA(String type, SearchResponse searchResponse) {

        DNAType dnaType = DNAType.valueOf(type);

        switch (dnaType) {

            case A: {
                searchResponse.incrementChainA();
                searchResponse.closeChainingAAsPossible();
                break;
            }
            case C: {
                searchResponse.incrementChainC();
                searchResponse.closeChainingCAsPossible();
                break;
            }
            case G: {
                searchResponse.incrementChainG();
                searchResponse.closeChainingGAsPossible();
                break;
            }
            case T: {
                searchResponse.incrementChainT();
                searchResponse.closeChainingTAsPossible();
                break;
            }
        }
    }
}
