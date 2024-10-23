package com.ParkCore.controller;

import com.ParkCore.service.impl.EventoService;
import com.ParkCore.model.Evento;
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
@RequestMapping("/event")
public class EventController {

	private final EventoService eventoService;

	public EventController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@Operation(summary = "Create an event", description = "This functionality is responsible for creating a new event in the system.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Event created successfully",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Evento.class))),
			@ApiResponse(responseCode = "400", description = "Could not create the event"),
			@ApiResponse(responseCode = "500", description = "Internal server error")
	})
	@PostMapping
	public ResponseEntity<Evento> createEvent(@RequestBody Evento eventRequest) {
		var event = eventoService.createEvento(eventRequest);
		return ResponseEntity.status(CREATED).body(event);
	}
}
