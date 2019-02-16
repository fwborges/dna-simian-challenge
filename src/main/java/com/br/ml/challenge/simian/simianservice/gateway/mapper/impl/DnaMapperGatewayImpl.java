package com.br.ml.challenge.simian.simianservice.gateway.mapper.impl;

import com.br.ml.challenge.simian.simianservice.db.model.DnaChainModel;
import com.br.ml.challenge.simian.simianservice.entity.DnaChainMeasured;
import com.br.ml.challenge.simian.simianservice.gateway.mapper.DnaMapperGateway;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DnaMapperGatewayImpl implements DnaMapperGateway {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Optional<DnaChainModel> convertToModel(Optional<DnaChainMeasured> dnaChain) {

        if(dnaChain.isPresent()) {
            return Optional.of(modelMapper.map(dnaChain.get(), DnaChainModel.class));
        }

        return Optional.empty();
    }

    @Override
    public Optional<DnaChainMeasured> convertToEntity(Optional<DnaChainModel> dnaChain) {

        if(dnaChain.isPresent()) {
            return Optional.of(modelMapper.map(dnaChain.get(), DnaChainMeasured.class));
        }

        return Optional.empty();
    }
}
