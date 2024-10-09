package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.service.impl.AtracaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    private final AtracaoService atracaoService;

    public AtracaoController(AtracaoService atracaoService) {
        this.atracaoService = atracaoService;
    }

    @GetMapping
    public ResponseEntity<List<Atracao>> listaAtracoes() {
        var atracoes = atracaoService.listaAtracoes();
        return ResponseEntity.ok(atracoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atracao> buscarPorId(@PathVariable Long id) {
        var atracao = atracaoService.buscarPorId(id);
        return ResponseEntity.ok(atracao);
    }

    @Operation(summary = "Buscar por tipo de atração")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atrações encontradas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma atração encontrada para o tipo especificado")
    })
    @GetMapping("/atracaoTipo/{tipo}")
    public ResponseEntity<List<Atracao>> buscarPorTipo(@PathVariable AtracaoTipo tipo) {
        var atracoes = atracaoService.buscarPorTipo(tipo);
        return ResponseEntity.ok(atracoes);
    }

    @Operation(summary = "Criar atração")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atração criada com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class))),
            @ApiResponse(responseCode = "400", description = "A atração já foi cadastrada")
    })
    @PostMapping
    public ResponseEntity<Atracao> createAtracao(@RequestBody Atracao atracao) {
        var novaAtracao = atracaoService.createAtracao(atracao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtracao);
    }

    @Operation(summary = "Deletar atração")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Atração deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Atração não encontrada"),
            @ApiResponse(responseCode = "400", description = "Atração não pode ser deletada, pois está associada a um Evento!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtracao(@PathVariable Long id) {
        atracaoService.deleteAtracao(id);
        return ResponseEntity.noContent().build();
    }
}