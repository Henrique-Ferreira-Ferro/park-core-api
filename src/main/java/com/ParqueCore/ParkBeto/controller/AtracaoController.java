package com.ParqueCore.ParkBeto.controller;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
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
import java.util.List;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestController
@RequestMapping("/atracoes")
public class AtracaoController {

    @Autowired
    private AtracaoService atracaoService;

    //Listar todas as atracoes
    @GetMapping
    public ResponseEntity<List<Atracao>> listaAtracoes(){
        List<Atracao> atracoes = atracaoService.listaAtracoes();
        return new ResponseEntity<>(atracoes, HttpStatus.OK);
    }
    //Busca por Id
    @GetMapping("/{id}")
    public ResponseEntity<Atracao> buscarPorId(@PathVariable Long id){
        var atracao = atracaoService.buscarPorId(id);
        return new ResponseEntity<>(atracao, HttpStatus.OK);
    }

    //Busca por tipo
    @Operation(summary = "Buscar por tipo de atração", description = "Funcionalidade responsável por listar atrações com base no tipo especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atrações encontradas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Atracao.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Nenhuma atração encontrada para o tipo especificado")
    })
    @GetMapping("/atracaoTipo/{tipo}")
    public ResponseEntity<List<Atracao>> buscarPorTipo(@PathVariable AtracaoTipo tipo){
        var atracao = atracaoService.buscarPorTipo(tipo);
        return new ResponseEntity<>(atracao, HttpStatus.OK);
    }
    //Metodo de criar uma atracao
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

    //metodo de deletar uma atracao
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
        atracaoService.deleteAtracao(id);
        return new ResponseEntity<>(BAD_REQUEST);

    }
}
