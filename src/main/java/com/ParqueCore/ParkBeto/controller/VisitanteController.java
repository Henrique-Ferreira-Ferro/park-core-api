package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;
    
    @PostMapping("/cadastrar")
    public Visitante cadastrarVisitante(@RequestBody Visitante visitante) {
    	return visitanteService.cadastrarVisitante(visitante);
    }
    
    @DeleteMapping
    public void excluirVisitante(@PathVariable Long visitanteId) {
        visitanteService.excluirVisitante(visitanteId);
    }
}
