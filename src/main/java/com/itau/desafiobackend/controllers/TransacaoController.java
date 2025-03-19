package com.itau.desafiobackend.controllers;

import com.itau.desafiobackend.DTOs.TransacaoDTO;
import com.itau.desafiobackend.services.EstatisticaService;
import com.itau.desafiobackend.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private EstatisticaService estatisticaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> createTransaction(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.create(transacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity <Void> deleteTransaction(){
        transacaoService.delete();
        return ResponseEntity.ok().build();
    }
}
