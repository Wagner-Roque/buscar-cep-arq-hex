package com.buscarcep.arq.hex.api_arq_hex.application.ports.output;


import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;

public interface BuscarCepClient {
    CepResponse consultarCep(String cep);
}