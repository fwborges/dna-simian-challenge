package com.br.ml.challenge.simian.simianservice.usecase.search.horizontal;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;

@UseCase
public class SearchHorizontal {


    public SearchResponse execute(String[][] matrixDNA) {

        SearchResponse searchResponse = new SearchResponse();

        for(int i = 0; i < matrixDNA.length; i++) {

            searchResponse.resetAll();

            for(int j = 0; j < matrixDNA.length; j++) {
                System.out.print("(" + i + "," + j +")");
                verifyDNA(matrixDNA[i][j], searchResponse);
            }
        }

        return searchResponse;
    }

    private void verifyDNA(String type, SearchResponse searchResponse) {
        System.out.println(searchResponse.toString());
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
