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

        Optional<DnaChainMeasured> byDna = chainRepoGateway.findByDna(inputDNA);

        if(byDna.isPresent()) {
            return byDna.get().getSimian();
        }

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

        DnaChainMeasured dnaChain = new DnaChainMeasured();
        dnaChain.setDna(Arrays.asList(inputDNA));
        dnaChain.setSimian(allSearchs.hasAnyDNAChain());

        chainRepoGateway.save(Optional.of(dnaChain));

        return allSearchs.hasAnyDNAChain();
    }

    private void validate(String[] dnaChain) {

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
