package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Ingresso;
import com.ParqueCore.ParkBeto.service.impl.IngressoService;
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

	@PostMapping
	public ResponseEntity<Ingresso> emitirIngresso(@RequestBody Ingresso ingressoRequest) {
		var ingresso = ingressoService.emitirIngresso(ingressoRequest);
		return ResponseEntity.ok(ingresso);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancelarIngresso(@PathVariable Long id) {
		ingressoService.cancelarIngresso(id);
		return ResponseEntity.ok("Ingresso cancelado com sucesso!");
	}

	@GetMapping
	public ResponseEntity<List<Ingresso>> listarIngressos() {
		var ingressos = ingressoService.listarIngressos();
		return ResponseEntity.ok(ingressos);
	}
}
