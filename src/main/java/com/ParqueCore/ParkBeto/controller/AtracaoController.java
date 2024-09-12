package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.impl.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    @Autowired
    private AtracaoService atracaoService;

    @PostMapping
    public ResponseEntity<Atracao> createAtracao(@RequestBody Atracao atracao){
        Atracao newAtracao = atracaoService.createAtracao(atracao);
        return new ResponseEntity<>(newAtracao, HttpStatus.CREATED);
    }

}
