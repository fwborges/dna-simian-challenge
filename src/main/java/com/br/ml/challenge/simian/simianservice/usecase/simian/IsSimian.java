package com.br.ml.challenge.simian.simianservice.usecase.simian;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallylefttoright.SearchDiagonallyLeftToRight;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallyrighttoleft.SearchDiagonallyRightToLeft;
import com.br.ml.challenge.simian.simianservice.usecase.search.horizontal.SearchHorizontal;
import com.br.ml.challenge.simian.simianservice.usecase.search.vertical.SearchVertical;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@UseCase
public class IsSimian {

    private SearchHorizontal searchHorizontal;

    private SearchVertical searchVertical;

    private SearchDiagonallyLeftToRight searchDiagonallyLeftToRight;

    private SearchDiagonallyRightToLeft searchDiagonallyRightToLeft;

    @Autowired
    public IsSimian(SearchHorizontal searchHorizontal, SearchVertical searchVertical, SearchDiagonallyLeftToRight searchDiagonallyLeftToRight, SearchDiagonallyRightToLeft searchDiagonallyRightToLeft) {

        this.searchHorizontal = searchHorizontal;
        this.searchVertical = searchVertical;
        this.searchDiagonallyLeftToRight = searchDiagonallyLeftToRight;
        this.searchDiagonallyRightToLeft = searchDiagonallyRightToLeft;
    }

    public Boolean execute(String[] inputDNA) {

        String[][] matrixDna = Arrays.stream(inputDNA)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        System.out.println(Arrays.deepToString(matrixDna).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


        SearchResponse responseHorizontal = searchHorizontal.execute(matrixDna);
        SearchResponse responseVertical = searchVertical.execute(matrixDna);
        SearchResponse responseDiagonalLR = searchDiagonallyLeftToRight.execute(matrixDna);
        SearchResponse responseDiagonalRL = searchDiagonallyRightToLeft.execute(matrixDna);

        System.out.println("Horizontal -> " + responseHorizontal.toString());
        System.out.println("Vertical -> " + responseVertical.toString());
        System.out.println("Diagonal LR -> " + responseDiagonalLR.toString());
        System.out.println("Diagonal RL -> " + responseDiagonalRL.toString());



        SearchResponse allSearchs = responseHorizontal
                                                    .merge(responseVertical)
                                                    .merge(responseDiagonalLR)
                                                    .merge(responseDiagonalRL);

        System.out.println(allSearchs.toString());

        return allSearchs.hasAnyDNAChain();
    }
}
