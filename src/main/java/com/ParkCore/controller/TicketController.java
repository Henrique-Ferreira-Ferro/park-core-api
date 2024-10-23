package com.ParkCore.controller;

import com.ParkCore.model.Ingresso;
import com.ParkCore.service.impl.IngressoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private final IngressoService ingressoService;

	public TicketController(IngressoService ingressoService) {
		this.ingressoService = ingressoService;
	}

	@Operation(summary = "Issue ticket")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Ticket issued successfully!",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Ingresso.class))),
			@ApiResponse(responseCode = "404", description = "Visitor not found"),
			@ApiResponse(responseCode = "404", description = "Attraction not found"),
	})
	@PostMapping
	public ResponseEntity<Ingresso> issueTicket(@RequestBody Ingresso ticketRequest) {
		var ticket = ingressoService.emitirIngresso(ticketRequest);
		return ResponseEntity.ok(ticket);
	}

	@Operation(summary = "Cancel ticket")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ticket deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Ticket not found"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancelTicket(@PathVariable Long id) {
		ingressoService.cancelarIngresso(id);
		return  ResponseEntity.ok("Ticket canceled successfully!");
	}

	@Operation(summary = "Get tickets")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tickets found successfully",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Ingresso.class))),
	})
	@GetMapping
	public ResponseEntity<List<Ingresso>> listTickets() {
		var tickets = ingressoService.listarIngressos();
		return ResponseEntity.ok(tickets);
	}
}
