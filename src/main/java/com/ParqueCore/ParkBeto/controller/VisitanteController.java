package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.service.impl.VisitanteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @Operation(summary = "Criação de um visitante", description = "Essa funcionalidade ......")
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "200", description = "Visitante cadastrado com sucesso!",
    					content = @Content(mediaType = "application/json",
    					schema = @Schema(implementation = Visitante.class)
    					)
    				),
    		@ApiResponse(responseCode = "400", description = "Problema ao cadastrar o Visitante!!")
    })
    @PostMapping("/cadastrar")
    public Visitante cadastrarVisitante(@RequestBody Visitante visitante) {
    	return visitanteService.cadastrarVisitante(visitante);
    }
    
    
    @Operation(summary = "Exclusão de um visitante", description = "Essa funcionalidade é responsavel por....")
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "200", description = "Visitante excluido com sucesso!!!",
    					content = @Content(mediaType = "application/json",
    					schema = @Schema(implementation = Visitante.class)
    					)
    				),
    		@ApiResponse(responseCode = "400", description = "Não foi possivel excluir o visitante"),
    		@ApiResponse(responseCode = "500", description = "Problema com a API!")
    })
    @DeleteMapping("/{id}")
    public void excluirVisitante(@PathVariable Long id) {
        visitanteService.excluirVisitante(id);
    }
}
