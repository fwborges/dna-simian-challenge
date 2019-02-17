package com.br.ml.challenge.simian.simianservice.usecase.search.horizontal;

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
public class SearchHorizontalTest {

    private SearchHorizontal searchHorizontal;

    @Before
    public void setUp() {

        searchHorizontal = new SearchHorizontal();
    }

    @Test
    public void shouldFoundOneDnaChainG() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGGGGTCC",
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

        SearchResponse searchResponse = searchHorizontal.execute(matrixDna);

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
                                        "ACAGTAAAAGTCTAG",
                                        "TATGCTCGTCAAGCG",
                                        "CTAAGACCACGTGCC",
                                        "AGAAGATGTGACACC",
                                        "CACCAAAACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = searchHorizontal.execute(matrixDna);

        assertEquals("Should have found two A Sequence",new Integer(2), searchResponse.getChainSumA());
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
                                        "CCCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = searchHorizontal.execute(matrixDna);

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
                                        "GATGCCTGTGCTTTT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = searchHorizontal.execute(matrixDna);

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

        SearchResponse searchResponse = searchHorizontal.execute(matrixDna);

        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }
}
