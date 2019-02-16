package com.br.ml.challenge.simian.simianservice.gateway.repository.impl;

import com.br.ml.challenge.simian.simianservice.db.model.DnaChainModel;
import com.br.ml.challenge.simian.simianservice.db.repository.DnaChainRepository;
import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;
import com.br.ml.challenge.simian.simianservice.gateway.mapper.DnaMapperGateway;
import com.br.ml.challenge.simian.simianservice.gateway.repository.DnaRepoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DnaRepoGatewayImpl implements DnaRepoGateway {

    @Autowired
    private DnaChainRepository repository;

    @Autowired
    private DnaMapperGateway mapperGateway;

    @Override
    public Optional<DnaChainMeasured> findByDna(String[] dnaChain) {

        Optional<DnaChainModel> dnaChainModel = repository.findByDna(dnaChain);

        return mapperGateway.convertToEntity(dnaChainModel);
    }

    @Override
    public Double countBySimianTrue() {
        return repository.countBySimianTrue();
    }

    @Override
    public Double countBySimianFalse() {
        return repository.countBySimianFalse();
    }

    @Override
    public Optional<DnaChainMeasured> save(Optional<DnaChainMeasured> dnaChain) {

        Optional<DnaChainModel> dnaChainModel = mapperGateway.convertToModel(dnaChain);

        DnaChainModel chainModel = repository.save(dnaChainModel.get());

        return mapperGateway.convertToEntity(Optional.of(chainModel));
    }
}
