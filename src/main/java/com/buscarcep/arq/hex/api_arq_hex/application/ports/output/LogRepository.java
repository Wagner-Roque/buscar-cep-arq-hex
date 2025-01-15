package com.buscarcep.arq.hex.api_arq_hex.application.ports.output;


import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository {
    void saveLog(LogEntity logEntity);
}
