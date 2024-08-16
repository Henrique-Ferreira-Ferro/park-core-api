package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Atracao create(@RequestBody Atracao atracao){
        return atracaoService.save(atracao);
    }

}
