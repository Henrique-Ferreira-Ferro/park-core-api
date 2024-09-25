package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.service.impl.EventoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@Operation(summary = "Criar um evento", description = "Essa funcionalidade é responsavel por criar um evento!")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento criado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class)
				)
			),
			@ApiResponse(responseCode = "400", description = "Não foi possivel criar o evento")
	})
	@PostMapping
	public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
		var newEvento = eventoService.createEvento(evento);
		return new ResponseEntity<>(newEvento, CREATED);
	}

}
