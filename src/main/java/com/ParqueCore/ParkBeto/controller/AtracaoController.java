package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    @Autowired
    private AtracaoService atracaoService;

    @PostMapping
    public ResponseEntity<Atracao> createAtracao(@RequestBody Atracao atracao) {
        var newAtracao = atracaoService.createAtracao(atracao);
        return new ResponseEntity<>(newAtracao, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAtracao(@PathVariable Long id) {
        try {
            atracaoService.deleteAtracao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}