package com.br.ml.challenge.simian.simianservice.usecase.simian;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;
import com.br.ml.challenge.simian.simianservice.gateway.repository.DnaRepoGateway;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallylefttoright.SearchDiagonallyLeftToRight;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallyrighttoleft.SearchDiagonallyRightToLeft;
import com.br.ml.challenge.simian.simianservice.usecase.search.horizontal.SearchHorizontal;
import com.br.ml.challenge.simian.simianservice.usecase.search.vertical.SearchVertical;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Optional;

@UseCase
public class IsSimian {

    public static final String ONLY_A_C_G_T = "[AaCcGgTt]+";

    private SearchHorizontal searchHorizontal;

    private SearchVertical searchVertical;

    private SearchDiagonallyLeftToRight searchDiagonallyLeftToRight;

    private SearchDiagonallyRightToLeft searchDiagonallyRightToLeft;

    private DnaRepoGateway chainRepoGateway;

    @Autowired
    public IsSimian(SearchHorizontal searchHorizontal, SearchVertical searchVertical, SearchDiagonallyLeftToRight searchDiagonallyLeftToRight, SearchDiagonallyRightToLeft searchDiagonallyRightToLeft, DnaRepoGateway chainRepoGateway) {

        this.searchHorizontal = searchHorizontal;
        this.searchVertical = searchVertical;
        this.searchDiagonallyLeftToRight = searchDiagonallyLeftToRight;
        this.searchDiagonallyRightToLeft = searchDiagonallyRightToLeft;
        this.chainRepoGateway = chainRepoGateway;
    }

    public Boolean execute(String[] inputDNA) {

        validate(inputDNA);

        Optional<DnaChainMeasured> dnaChainMeasured = chainRepoGateway.findByDna(inputDNA);

        if(dnaChainMeasured.isPresent()) {
            return dnaChainMeasured.get().getSimian();
        }

        String[][] matrixDna = convertToMatrix(inputDNA);

        SearchResponse responseHorizontal = searchHorizontal.execute(matrixDna);
        SearchResponse responseVertical = searchVertical.execute(matrixDna);
        SearchResponse responseDiagonalLR = searchDiagonallyLeftToRight.execute(matrixDna);
        SearchResponse responseDiagonalRL = searchDiagonallyRightToLeft.execute(matrixDna);

        SearchResponse allSearch = responseHorizontal
                                                    .merge(responseVertical)
                                                    .merge(responseDiagonalLR)
                                                    .merge(responseDiagonalRL);

        saveDnaOnDB(inputDNA, allSearch);

        return allSearch.hasAnyDNAChain();
    }

    private void saveDnaOnDB(String[] inputDNA, SearchResponse allSearchs) {

        DnaChainMeasured dnaChain = new DnaChainMeasured();
        dnaChain.setDna(Arrays.asList(inputDNA));
        dnaChain.setSimian(allSearchs.hasAnyDNAChain());

        chainRepoGateway.save(Optional.of(dnaChain));
    }

    private String[][] convertToMatrix(String[] inputDNA) {
        return Arrays.stream(inputDNA)
                    .map(line -> line.toUpperCase().split(""))
                    .toArray(String[][]::new);
    }

    private void validate(String[] dnaChain) {

        int length = dnaChain.length;

        Arrays.stream(dnaChain).forEach(dna -> {

            if(dna.length() != length) {
                throw new IllegalInputDNAException("This input is not square matrix");
            }

            if(!dna.matches(ONLY_A_C_G_T)) {
                throw new IllegalInputDNAException("Input has characters not allowed");
            }

        });
    }
}
