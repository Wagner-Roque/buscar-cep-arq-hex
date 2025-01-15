package com.buscarcep.arq.hex.api_arq_hex.application.service;

import com.buscarcep.arq.hex.api_arq_hex.application.ports.input.BuscarCepUseCase;
import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.BuscarCepClient;
import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.LogRepository;
import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;
import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import com.buscarcep.arq.hex.api_arq_hex.infrastructure.util.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Service
public class BuscarCepService implements BuscarCepUseCase {
    private final LogRepository logRepository;
    private final BuscarCepClient cepClient;

    public BuscarCepService(LogRepository logRepository, BuscarCepClient cepClient) {
        this.logRepository = logRepository;
        this.cepClient = cepClient;
    }

    @Override
    public CepResponse buscarCep(String cep) {
        CepResponse response = cepClient.consultarCep(cep);
        LogEntity log = new LogEntity();
        logRepository.saveLog(log);
        return response;
    }
}