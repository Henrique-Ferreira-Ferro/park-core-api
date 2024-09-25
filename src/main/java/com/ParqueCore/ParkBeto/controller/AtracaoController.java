package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.impl.AtracaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    @Autowired
    private AtracaoService atracaoService;
    
    @Operation(summary = "Criar atração", description = "Funcionalidade responsavel por criar uma nova atração")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Atração criada com sucesso!",
    				content = @Content(mediaType = "application/json",
    				schema = @Schema(implementation = Atracao.class)
    				)
    			),
    		@ApiResponse(responseCode = "400", description= "A atracao ja foi cadastrada")
    })
    @PostMapping
    public ResponseEntity<Atracao> createAtracao(@RequestBody Atracao atracao) {
        Atracao newAtracao = atracaoService.createAtracao(atracao);
        return new ResponseEntity<>(newAtracao, HttpStatus.CREATED);
    }

    
    @Operation(summary = "Deletar atração", description = "Funcionalidade responsavel por deletar uma atração por ID")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "",
    				content = @Content(mediaType = "application/json",
    				schema = @Schema(implementation = Atracao.class)
    				)
    		),
    		@ApiResponse(responseCode = "404", description = "Atração não encontrada"),
    		@ApiResponse(responseCode = "400", description = "Atração não pode ser deletada, pois está associada a um Evento!")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteAtracao(@PathVariable Long id) {

        //TODO: MIGRAR ESSA LÓGICA PARA O SERVIÇO!

        try {
            atracaoService.deleteAtracao(id);
            return new ResponseEntity<>(NO_CONTENT);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }

    }
}
