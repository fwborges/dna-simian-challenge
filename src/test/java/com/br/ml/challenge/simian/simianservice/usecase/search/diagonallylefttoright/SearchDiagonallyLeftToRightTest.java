package com.br.ml.challenge.simian.simianservice.usecase.search.diagonallylefttoright;

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
public class SearchDiagonallyLeftToRightTest {

    private SearchDiagonallyLeftToRight leftToRight;

    @Before
    public void setUp() {
        leftToRight = new SearchDiagonallyLeftToRight();
    }

    @Test
    public void shouldFoundOneDnaChainG() {

        String[] input = new String[]{"ATCTGAGTGACTCGA",
                                      "CGGACAACTATCACA",
                                      "TATATGTGGCGGTCC",
                                      "GCTCTAATAGCGCGT",
                                      "AGGCCTCGTTAGATT",
                                      "GCAGGAATAGTCTAG",
                                      "TGTGCTCGTCAAGCG",
                                      "CTGAGACCACGTGCC",
                                      "AGAGGATGTGACACC",
                                      "CTCCAACACATCTGT",
                                      "GATGCCTGTGCGATT",
                                      "TCCATGCACAGTCGG",
                                      "TCTGCCGTGTGTCGG",
                                      "AGATATACATACGTA",
                                      "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = leftToRight.execute(matrixDna);

        assertEquals("Should have found G Sequence",new Integer(1), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }


    @Test
    public void shouldFoundOneDnaChainC() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "CCAGGAATAGTCTAG",
                                        "TCTGCTCGTCCAGCG",
                                        "CTCAGACCACGTGCC",
                                        "AGACGATGCGACACC",
                                        "CTCCAACCCATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = leftToRight.execute(matrixDna);

        assertEquals("Should have found C Sequence",new Integer(1), searchResponse.getChainSumC());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
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
                "CCAGGAATAGTCTAG",
                "TATGATCGTCAAGCG",
                "CTCAGACCACGTGCC",
                "AGACGATGTGACACC",
                "CACCAACACATCTGT",
                "AATGCCTGTGCGATT",
                "TACATGCACAGTCGG",
                "TCAGCCGTGTGTCGG",
                "AGAAATACATACGTA",
                "CTCAACTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = leftToRight.execute(matrixDna);

        assertEquals("Should have found A Sequence",new Integer(1), searchResponse.getChainSumA());
        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
    }

    @Test
    public void shouldFoundOneDnaChainT() {

        String[] input = new String[]{  "ATCTGAGTGACTCGA",
                                        "CGGACAACTATCACA",
                                        "TATATGTGGCGGTCC",
                                        "GCTCTAATAGCGCGT",
                                        "AGGCCTCGTTAGATT",
                                        "TCAGGAATAGTCTAG",
                                        "TTTGCTCGTCAAGCG",
                                        "CTTAGACCACGTGCC",
                                        "AGATGATGTGACACC",
                                        "CTCCAACACTTCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCTCAGTCGG",
                                        "TCTGCCTTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = leftToRight.execute(matrixDna);

        assertEquals("Should have not found T Sequence",new Integer(1), searchResponse.getChainSumT());
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
                                        "GCAGGAATAGTCTAG",
                                        "TGTGCTCGTCAAGCG",
                                        "CTCAGACCACGTGCC",
                                        "AGAGGATGTGACACC",
                                        "CTCCAACACATCTGT",
                                        "GATGCCTGTGCGATT",
                                        "TCCATGCACAGTCGG",
                                        "TCTGCCGTGTGTCGG",
                                        "AGATATACATACGTA",
                                        "CTCAGCTGAGACGTA"};

        String[][] matrixDna = Arrays.stream(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        SearchResponse searchResponse = leftToRight.execute(matrixDna);

        assertEquals("Should have not found G Sequence",new Integer(0), searchResponse.getChainSumG());
        assertEquals("Should have not found C Sequence",new Integer(0), searchResponse.getChainSumC());
        assertEquals("Should have not found T Sequence",new Integer(0), searchResponse.getChainSumT());
        assertEquals("Should have not found A Sequence",new Integer(0), searchResponse.getChainSumA());
    }
}
