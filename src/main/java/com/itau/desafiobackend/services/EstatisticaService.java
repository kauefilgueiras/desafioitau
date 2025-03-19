package com.itau.desafiobackend.services;

import com.itau.desafiobackend.DTOs.EstatisticaDTO;
import com.itau.desafiobackend.DTOs.TransacaoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
public class EstatisticaService {
    @Autowired
    public TransacaoService transacaoService;

    public EstatisticaDTO calculoEstatisticas(Integer intervalo){
        log.info("Iniciando a busca por transações dentro do período de " + intervalo);
        List<TransacaoDTO> transacaos = transacaoService.getTransacoes(intervalo);
        if (transacaos.isEmpty()) {
            return new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics stats = transacaos.stream()
                .mapToDouble(TransacaoDTO::valor)
                .summaryStatistics();

        return new EstatisticaDTO(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMax(),
                stats.getMin()
        );
    }
}
