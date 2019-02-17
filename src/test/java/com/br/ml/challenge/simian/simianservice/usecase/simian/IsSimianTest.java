package com.br.ml.challenge.simian.simianservice.usecase.simian;

import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;
import com.br.ml.challenge.simian.simianservice.gateway.repository.DnaRepoGateway;
import com.br.ml.challenge.simian.simianservice.usecase.search.SearchResponse;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallylefttoright.SearchDiagonallyLeftToRight;
import com.br.ml.challenge.simian.simianservice.usecase.search.diagonallyrighttoleft.SearchDiagonallyRightToLeft;
import com.br.ml.challenge.simian.simianservice.usecase.search.horizontal.SearchHorizontal;
import com.br.ml.challenge.simian.simianservice.usecase.search.vertical.SearchVertical;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsSimianTest {

    private IsSimian isSimian;

    @Mock
    private SearchHorizontal searchHorizontal;

    @Mock
    private SearchVertical searchVertical;

    @Mock
    private SearchDiagonallyLeftToRight searchDiagonallyLeftToRight;

    @Mock
    private SearchDiagonallyRightToLeft searchDiagonallyRightToLeft;

    @Mock
    private DnaRepoGateway chainRepoGateway;

    @Before
    public void setUp() {

        isSimian = new IsSimian(searchHorizontal,searchVertical,searchDiagonallyLeftToRight,searchDiagonallyRightToLeft, chainRepoGateway);
    }

    private SearchResponse buildSearchResponse() {

        SearchResponse response = new SearchResponse();
        response.incrementChainA();
        response.incrementChainA();
        response.incrementChainA();
        response.incrementChainA();
        response.closeChainingAAsPossible();

        return response;
    }

    @Test
    public void shouldReturnSimianDnaByAlgorithm() {

        String[] dna = new String[]{"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        when(searchHorizontal.execute(any())).thenReturn(buildSearchResponse());
        when(searchVertical.execute(any())).thenReturn(new SearchResponse());
        when(searchDiagonallyLeftToRight.execute(any())).thenReturn(new SearchResponse());
        when(searchDiagonallyRightToLeft.execute(any())).thenReturn(new SearchResponse());

        Boolean isSimian = this.isSimian.execute(dna);

        assertTrue(isSimian);
    }

    @Test
    public void shouldReturnHumanDnaByAlgorithm() {

        String[] dna = new String[]{"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        when(searchHorizontal.execute(any())).thenReturn(new SearchResponse());
        when(searchVertical.execute(any())).thenReturn(new SearchResponse());
        when(searchDiagonallyLeftToRight.execute(any())).thenReturn(new SearchResponse());
        when(searchDiagonallyRightToLeft.execute(any())).thenReturn(new SearchResponse());

        Boolean isSimian = this.isSimian.execute(dna);

        assertFalse(isSimian);
    }

    @Test
    public void shouldReturnHumanDnaByDB() {

        String[] dna = new String[]{"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        DnaChainMeasured chainMeasured = new DnaChainMeasured();
        chainMeasured.setSimian(false);

        Optional<DnaChainMeasured> dnaChainMeasured = Optional.of(chainMeasured);

        when(chainRepoGateway.findByDna(dna)).thenReturn(dnaChainMeasured);

        Boolean isSimian = this.isSimian.execute(dna);

        assertFalse(isSimian);
    }


    @Test
    public void shouldReturnSimianDnaByDB() {

        String[] dna = new String[]{"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        DnaChainMeasured chainMeasured = new DnaChainMeasured();
        chainMeasured.setSimian(true);

        Optional<DnaChainMeasured> dnaChainMeasured = Optional.of(chainMeasured);

        when(chainRepoGateway.findByDna(dna)).thenReturn(dnaChainMeasured);

        Boolean isSimian = this.isSimian.execute(dna);

        assertTrue(isSimian);
    }

    @Test(expected = IllegalInputDNAException.class)
    public void shouldThrowsIllegalInputDnaExceptionWhenHasInvalidCharacters() {

        String[] dna = new String[]{"3TGAGA", "CT5TGC", "TATTGT", "AHAGGG", "CCCCTA", "TCACTG"};

        isSimian.execute(dna);
    }


    @Test(expected = IllegalInputDNAException.class)
    public void shouldThrowsIllegalInputDnaExceptionWhenIsNotSquareMatrix() {

        String[] dna = new String[]{"CTGAG", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        isSimian.execute(dna);
    }
}
