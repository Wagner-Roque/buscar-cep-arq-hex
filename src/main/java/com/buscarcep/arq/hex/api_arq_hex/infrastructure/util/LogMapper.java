package com.buscarcep.arq.hex.api_arq_hex.infrastructure.util;


import com.buscarcep.arq.hex.api_arq_hex.domain.CepResponse;
import com.buscarcep.arq.hex.api_arq_hex.domain.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface  LogMapper {
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "logradouro", source = "response.logradouro")
    @Mapping(target = "bairro", source = "response.bairro")
    @Mapping(target = "localidade", source = "response.localidade")
    @Mapping(target = "uf", source = "response.uf")
    @Mapping(target = "timestamp", expression = "java(LogMapper.now())")
    LogEntity toEntity(String cep, CepResponse response);
    static LocalDateTime now() {
        return LocalDateTime.now();
    }
}

