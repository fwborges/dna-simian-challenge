package com.br.ml.challenge.simian.simianservice.usecase.search.diagonallyrighttoleft;

import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchDiagonallyRightToLeftTest {

    private SearchDiagonallyRightToLeft diagonallyRightToLeft;

    @Before
    public void setUp() {

        diagonallyRightToLeft = new SearchDiagonallyRightToLeft();
    }


    @Test
    public void shouldFoundOneDnaChainG() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "CCGGTAATAGTCTAG",
                                        "TCTGCTCGTCAAGCG",
                                        "CTCAGACCACGTGCC",
                                        "AGAAGATGTGACACC",
                                        "CTCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = diagonallyRightToLeft.execute(matrixDna);

        assertEquals("Should have found G Sequence",new Integer(1), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }


    @Test
    public void shouldFoundOneDnaChainA() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "ACAGTAATAGTCTAG",
                                        "TATGCTCGTCAAGCG",
                                        "CTAAGACCACGTGCC",
                                        "AGAAGATGTGACACC",
                                        "CTCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = diagonallyRightToLeft.execute(matrixDna);

        assertEquals("Should have found A Sequence",new Integer(1), searchResponse.getChainSumA());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
    }


    @Test
    public void shouldFoundOneDnaChainC() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "CCAGTAATAGTCTAG",
                                        "TCTGCTCGTCAAGCG",
                                        "CTCAGACCACGTGCC",
                                        "AGACGATGTGACACC",
                                        "CTCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = diagonallyRightToLeft.execute(matrixDna);

        assertEquals("Should have found C Sequence",new Integer(1), searchResponse.getChainSumC());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
    }

    @Test
    public void shouldFoundOneDnaChainT() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "TCAGTAATAGTCTAG",
                                        "TTTGCTCGTCAAGCG",
                                        "CTTAGACCACGTGCC",
                                        "AGATGATGTGACACC",
                                        "CTCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = diagonallyRightToLeft.execute(matrixDna);

        assertEquals("Should have found T Sequence",new Integer(1), searchResponse.getChainSumT());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }

    @Test
    public void shouldFoundNoOneDnaChain() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                "CGGACAACTATCACA",
                "TATATGTGGCGGTCC",
                "GCTCTAATAGCGCGT",
                "AGGCCTCGTTAGATT",
                "CCAGTAATAGTCTAG",
                "TCTGCTCGTCAAGCG",
                "CTAAGACCACGTGCC",
                "AGACGATGTGACACC",
                "CTCCAACACATCTGT",
                "GATGCCTGTGCGATT",
                "TCCATGCACAGTCGG",
                "TCTGCCGTGTGTCGG",
                "AGATATACATACGTA",
                "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = diagonallyRightToLeft.execute(matrixDna);

        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }
}
