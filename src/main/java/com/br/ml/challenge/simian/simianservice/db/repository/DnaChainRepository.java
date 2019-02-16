package com.br.ml.challenge.simian.simianservice.db.repository;

import com.br.ml.challenge.simian.simianservice.db.model.DnaChainModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaChainRepository extends MongoRepository<DnaChainModel, Long> {

    Optional<DnaChainModel> findByDna(String[] dnaChain);

    Double countBySimianTrue();

    Double countBySimianFalse();
}
