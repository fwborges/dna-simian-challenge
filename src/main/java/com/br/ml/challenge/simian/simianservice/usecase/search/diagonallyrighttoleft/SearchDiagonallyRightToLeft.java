package com.br.ml.challenge.simian.simianservice.usecase.search.diagonallyrighttoleft;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.entity.DNAType;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;

@UseCase
public class SearchDiagonallyRightToLeft {

    public SearchResponse execute(String[][] matrixDNA) {

        SearchResponse searchResponse = new SearchResponse();

        for(int k = 0; k <= matrixDNA.length -1; k++) {

            int j = k;
            int i = matrixDNA.length - 1;

            searchResponse.resetAll();
            while(j >= 0){ //go until first column

                verifyDNA(matrixDNA[i][j],searchResponse);

                i= i-1;
                j= j-1;
            }

        }

        for(int k = matrixDNA.length - 2; k >= 0; k--) {

            int i = k;
            int j = matrixDNA.length - 1;

            searchResponse.resetAll();

            while(i >= 0) {

                verifyDNA(matrixDNA[i][j], searchResponse);

                i=i-1;
                j=j-1;
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
