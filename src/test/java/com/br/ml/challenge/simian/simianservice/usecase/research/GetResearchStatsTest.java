package com.br.ml.challenge.simian.simianservice.usecase.research;

import com.br.ml.challenge.simian.simianservice.gateway.repository.DnaRepoGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetResearchStatsTest {

    private GetResearchStats getResearchStats;

    @Mock
    private DnaRepoGateway chainRepoGateway;

    @Before
    public void setUp() {

        getResearchStats = new GetResearchStats(chainRepoGateway);
    }

    @Test
    public void shouldCalcultateDNARatio() {

        when(chainRepoGateway.countBySimianFalse()).thenReturn(new Double(100));
        when(chainRepoGateway.countBySimianTrue()).thenReturn(new Double(40));

        ResearchStats researchStats = getResearchStats.execute();

        assertEquals("Should have 100 human dna", new Double(100), researchStats.getCount_human_dna());
        assertEquals("Should have 40 human dna", new Double(40), researchStats.getCount_mutant_dna());
        assertEquals("Should have 0.4 ratio", new Double(0.4), researchStats.getRatio());
    }
}
