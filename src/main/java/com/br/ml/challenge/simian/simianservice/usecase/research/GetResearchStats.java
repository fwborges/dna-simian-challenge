package com.br.ml.challenge.simian.simianservice.usecase.research;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.gateway.repository.DnaRepoGateway;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class GetResearchStats {

    private DnaRepoGateway chainRepoGateway;

    @Autowired
    public GetResearchStats(DnaRepoGateway chainRepoGateway) {
        this.chainRepoGateway = chainRepoGateway;
    }

    public ResearchStats execute() {

        ResearchStats researchStatus = new ResearchStats();

        Double simianCount = chainRepoGateway.countBySimianTrue();
        Double humanCount = chainRepoGateway.countBySimianFalse();

        researchStatus.setCount_mutant_dna(simianCount);
        researchStatus.setCount_human_dna(humanCount);
        researchStatus.setRatio(simianCount / humanCount);

        return researchStatus;
    }
}
