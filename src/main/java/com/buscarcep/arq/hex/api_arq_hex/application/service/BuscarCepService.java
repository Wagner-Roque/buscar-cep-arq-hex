package com.buscarcep.arq.hex.api_arq_hex.application.service;

import com.buscarcep.arq.hex.api_arq_hex.application.ports.input.BuscarCepUseCase;
import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.BuscarCepClient;
import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.LogRepository;
import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;
import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import com.buscarcep.arq.hex.api_arq_hex.infrastructure.util.LogMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
@Slf4j
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
        CepResponse response = null;
        try {
            response = cepClient.consultarCep(cep);

            LogEntity log = new LogEntity();

            log.setCep(cep);
            log.setBairro(response.bairro());
            log.setLocalidade(response.localidade());
            log.setLogradouro(response.logradouro());
            log.setUf(response.uf());
            log.setTimestamp(LocalDateTime.now());

            logRepository.saveLog(log);
        } catch (Exception e) {
            // Logar a exceção com mais detalhes
            LogEntity logError = new LogEntity();

            logError.setCep(cep);

            throw new RuntimeException("Erro ao buscar CEP", e);
        }
        return response;
    }
}