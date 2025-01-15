package com.buscarcep.arq.hex.api_arq_hex.infrastructure.adapters.output.database;

import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.LogRepository;
import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import org.springframework.stereotype.Component;

@Component
public class LogRepositoryAdapter implements LogRepository {
    private final LogMongoRepository mongoRepository;

    public LogRepositoryAdapter(LogMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public void saveLog(LogEntity logEntity) {
        mongoRepository.save(logEntity);
    }
}
