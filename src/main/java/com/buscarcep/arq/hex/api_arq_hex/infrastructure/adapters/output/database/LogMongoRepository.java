package com.buscarcep.arq.hex.api_arq_hex.infrastructure.adapters.output.database;

import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMongoRepository extends MongoRepository<LogEntity, String> {}
