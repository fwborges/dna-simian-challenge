package com.br.ml.challenge.simian.simianservice.usecase.search.diagonallylefttoright;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;

@UseCase
public class SearchDiagonallyLeftToRight {

    private SearchResponse searchResponse = new SearchResponse();

    public SearchResponse execute(String[][] matrixDNA) {

        for(int k = 0; k <= matrixDNA.length -1; k++) {

            int i = k;
            int j = 0;

            while(i >= 0){ //go until first row

                System.out.print(matrixDNA[i][j]);
                verifyDNA(matrixDNA[i][j]);

                i= i-1;
                j = j+1;
            }

            System.out.println(" ");
        }

        for(int k=1; k<= matrixDNA.length -1; k++) {

            int i = matrixDNA.length -1;
            int j = k;

            while(j <= matrixDNA.length -1) {
                System.out.print(matrixDNA[i][j]);
                verifyDNA(matrixDNA[i][j]);

                i=i-1;
                j=j+1;
            }
            System.out.println(" ");
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
