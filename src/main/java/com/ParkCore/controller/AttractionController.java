package com.ParkCore.controller;

import com.ParkCore.model.Atracao;
import com.ParkCore.service.impl.AtracaoService;
import com.ParkCore.enums.AtracaoTipo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AtracaoService atracaoService;

    public AttractionController(AtracaoService atracaoService) {
        this.atracaoService = atracaoService;
    }

    @Operation(summary = "Search for attractions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found attractions",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class))),
    })
    @GetMapping
    public ResponseEntity<List<Atracao>> listAttractions() {
        var attractions = atracaoService.listaAtracoes();
        return ResponseEntity.ok(attractions);
    }

    @Operation(summary = "Search by attraction type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found attractions",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class))),
            @ApiResponse(responseCode = "404", description = "No attractions found for the specified type")
    })
    @GetMapping("/attractionType/{type}")
    public ResponseEntity<List<Atracao>> getAttractionsByType(@PathVariable AtracaoTipo tipo) {
        var attractions = atracaoService.buscarPorTipo(tipo);
        return ResponseEntity.ok(attractions);
    }

    @Operation(summary = "Create attractions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Attraction created successfully!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class))),
            @ApiResponse(responseCode = "400", description = "The attraction has already been registered")
    })
    @PostMapping
    public ResponseEntity<Atracao> createAttraction(@RequestBody Atracao atracao) {
        var attraction = atracaoService.createAtracao(atracao);
        return ResponseEntity.status(CREATED).body(attraction);
    }

    @Operation(summary = "Deletar atração")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Atração deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Atração não encontrada"),
            @ApiResponse(responseCode = "400", description = "Atração não pode ser deletada, pois está associada a um Evento!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable Long id) {
        atracaoService.deleteAtracao(id);
        return ResponseEntity.noContent().build();
    }
}