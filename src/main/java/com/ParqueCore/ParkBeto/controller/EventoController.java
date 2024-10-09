package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.service.impl.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/evento")
public class EventoController {

	private final EventoService eventoService;

	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@Operation(summary = "Criar um evento", description = "Essa funcionalidade é responsável por criar um novo evento no sistema.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Evento criado com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Evento.class))),
			@ApiResponse(responseCode = "400", description = "Não foi possível criar o evento"),
			@ApiResponse(responseCode = "500", description = "Erro interno no servidor")
	})
	@PostMapping
	public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
		var novoEvento = eventoService.createEvento(evento);
		return ResponseEntity.status(CREATED).body(novoEvento);
	}
}
