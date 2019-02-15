package com.br.ml.challenge.simian.simianservice.repository;

import com.br.ml.challenge.simian.simianservice.entity.DnaChain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaChainRepository extends MongoRepository<DnaChain, Long> {

    Optional<DnaChain> findByDna(String[] dnaChain);
}
