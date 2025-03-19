package com.itau.desafiobackend.services;

import com.itau.desafiobackend.DTOs.TransacaoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class TransacaoService {
    private List <TransacaoDTO> transacaos = new ArrayList<>();

    public void create(TransacaoDTO transacaoDTO){
        log.info("Criando uma nova transação...");
        if (transacaoDTO == null || transacaoDTO.dataHora() == null || transacaoDTO.valor() == null){
            throw new IllegalArgumentException("Dados invalidos!");
        }
        if (transacaoDTO.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Erro ao criar uma transação! Data e hora maior que a data atual ");
            throw new IllegalArgumentException("data e hora maior que a data atual");
        }
        transacaos.add(transacaoDTO);
        log.info("Transação criada com sucesso!");
    }

    public List<TransacaoDTO> getTransacoes(Integer intervalo){
        OffsetDateTime currentTime = OffsetDateTime.now().minusSeconds(intervalo);
        return transacaos.stream().filter(item -> item.dataHora().isAfter(currentTime)).toList();
    }

    public void delete(){
        log.info("Deletando transação...");
        transacaos.clear();
        log.info("Transação deletada!");
    }
}
