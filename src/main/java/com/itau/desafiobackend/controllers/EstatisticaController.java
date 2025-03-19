package com.itau.desafiobackend.controllers;

import com.itau.desafiobackend.DTOs.EstatisticaDTO;
import com.itau.desafiobackend.services.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    @Autowired
    public EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatisticas(@RequestParam(value = "intervalo", required = false, defaultValue = "60") Integer intervalo){
        return ResponseEntity.ok(
                estatisticaService.calculoEstatisticas(intervalo)
        );
    }
}
