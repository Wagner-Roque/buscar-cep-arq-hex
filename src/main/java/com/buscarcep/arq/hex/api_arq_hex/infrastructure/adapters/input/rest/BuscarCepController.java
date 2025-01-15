package com.buscarcep.arq.hex.api_arq_hex.infrastructure.adapters.input.rest;

import com.buscarcep.arq.hex.api_arq_hex.application.ports.input.BuscarCepUseCase;

import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;
import io.swagger.annotations.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cep")
@Api(tags = "Busca CEP")
public class BuscarCepController {
    private final BuscarCepUseCase buscarCepUseCase;

    public BuscarCepController(BuscarCepUseCase buscarCepUseCase) {
        this.buscarCepUseCase = buscarCepUseCase;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable String cep) {
        return ResponseEntity.ok(buscarCepUseCase.buscarCep(cep));
    }
}