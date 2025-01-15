package com.buscarcep.arq.hex.api_arq_hex.application.ports.input;

import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;

public interface BuscarCepUseCase {
    CepResponse buscarCep(String cep);
}
