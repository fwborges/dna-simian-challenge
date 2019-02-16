package com.br.ml.challenge.simian.simianservice.gateway.mapper;

import com.br.ml.challenge.simian.simianservice.db.model.DnaChainModel;
import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;

import java.util.Optional;

public interface DnaMapperGateway {

    Optional<DnaChainModel> convertToModel(Optional<DnaChainMeasured> dnaChain);

    Optional<DnaChainMeasured> convertToEntity(Optional<DnaChainModel> dnaChain);
}
