package com.br.ml.challenge.simian.simianservice.usecase.research;

import com.br.ml.challenge.simian.simianservice.common.UseCase;
import com.br.ml.challenge.simian.simianservice.dto.ResearchStatus;
import com.br.ml.challenge.simian.simianservice.repository.DnaChainRepository;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class GetResearchStats {

    private DnaChainRepository repository;

    @Autowired
    public GetResearchStats(DnaChainRepository repository) {
        this.repository = repository;
    }

    public ResearchStatus execute() {

        ResearchStatus researchStatus = new ResearchStatus();

        Double simianCount = repository.countBySimianTrue();
        Double humanCount = repository.countBySimianFalse();

        researchStatus.setCountHumanDna(humanCount);
        researchStatus.setCountMutantDna(simianCount);
        researchStatus.setRatio(simianCount / humanCount);

        return researchStatus;
    }
}
