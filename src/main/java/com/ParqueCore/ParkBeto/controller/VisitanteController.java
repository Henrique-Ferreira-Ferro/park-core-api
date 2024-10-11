package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.service.impl.VisitanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    private final VisitanteService visitanteService;

    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    @Operation(summary = "Criação de um visitante", description = "Essa funcionalidade cadastra um novo visitante no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Visitante cadastrado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Visitante.class))),
            @ApiResponse(responseCode = "400", description = "Problema ao cadastrar o visitante!")
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<Visitante> cadastrarVisitante(@RequestBody Visitante visitante) {
        var novoVisitante = visitanteService.cadastrarVisitante(visitante);
        return ResponseEntity.status(CREATED).body(novoVisitante);
    }

    @Operation(summary = "Exclusão de um visitante", description = "Essa funcionalidade exclui um visitante do sistema pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Visitante excluído com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Visitante não encontrado"),
            @ApiResponse(responseCode = "400", description = "Não foi possível excluir o visitante"),
            @ApiResponse(responseCode = "500", description = "Problema com a API!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVisitante(@PathVariable Long id) {
        visitanteService.excluirVisitante(id);
        return ResponseEntity.noContent().build();
    }
}
