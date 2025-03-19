package com.itau.desafiobackend.DTOs;

public record EstatisticaDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
    ){
}
