package com.itau.desafiobackend.DTOs;

import java.time.OffsetDateTime;

public record TransacaoDTO(
        Double valor,
        OffsetDateTime dataHora
    ){
}
