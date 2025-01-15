package com.buscarcep.arq.hex.api_arq_hex.infrastructure.adapters.output.external;

import com.buscarcep.arq.hex.api_arq_hex.application.ports.output.BuscarCepClient;
import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CepClientAdapter implements BuscarCepClient {
    @Value("${viaCep.url}")
    private String viaCepUrl;
    private final WebClient webClient;

    public CepClientAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public CepResponse consultarCep(String cep) {
        return webClient.get()
                .uri(viaCepUrl + cep + "/json")
                .retrieve()
                .bodyToMono(CepResponse.class)
                .block();
    }
}