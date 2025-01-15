package com.buscarcep.arq.hex.api_arq_hex.domain;

public record CepResponse(  String cep,
         String logradouro,
         String complemento,
         String bairro,
         String localidade,
         String uf) {
}
