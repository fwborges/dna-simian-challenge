package com.br.ml.challenge.simian.simianservice.gateway.repository;

import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;

import java.util.Optional;

public interface DnaRepoGateway {

    Optional<DnaChainMeasured> findByDna(String[] dnaChain);

    Double countBySimianTrue();

    Double countBySimianFalse();

    Optional<DnaChainMeasured> save(Optional<DnaChainMeasured> dnaChain);
}
