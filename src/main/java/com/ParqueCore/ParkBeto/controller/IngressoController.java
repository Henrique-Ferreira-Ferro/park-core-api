package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Ingresso;
import com.ParqueCore.ParkBeto.service.impl.IngressoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {

	private final IngressoService ingressoService;

	public IngressoController(IngressoService ingressoService) {
		this.ingressoService = ingressoService;
	}

	@Operation(summary = "Emitir ingresso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Ingresso emitido com sucesso!",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Ingresso.class))),
			@ApiResponse(responseCode = "404", description = "Visitante não encontrado"),
			@ApiResponse(responseCode = "404", description = "Atracao nao encontrada"),

	})
	@PostMapping
	public ResponseEntity<Ingresso> emitirIngresso(@RequestBody Ingresso ingressoRequest) {
		var ingresso = ingressoService.emitirIngresso(ingressoRequest);
		return ResponseEntity.ok(ingresso);
	}

	@Operation(summary = "Cancelar ingresso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ingresso deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Ingresso não encontrada"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancelarIngresso(@PathVariable Long id) {
		ingressoService.cancelarIngresso(id);
		return ResponseEntity.ok("Ingresso cancelado com sucesso!");
	}

	@Operation(summary = "Buscar ingressos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ingressos encontrados com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Ingresso.class))),
	})
	@GetMapping
	public ResponseEntity<List<Ingresso>> listarIngressos() {
		var ingressos = ingressoService.listarIngressos();
		return ResponseEntity.ok(ingressos);
	}
}
