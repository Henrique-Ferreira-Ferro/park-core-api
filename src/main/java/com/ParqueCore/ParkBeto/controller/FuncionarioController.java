package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Funcionario;
import com.ParqueCore.ParkBeto.service.impl.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
	public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		var createdFuncionario = funcionarioService.cadastrarFuncionario(funcionario);
		return new ResponseEntity<>(createdFuncionario, CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		var updatedFuncionario = funcionarioService.atualizarFuncionario(id, funcionario);
		return ResponseEntity.ok(updatedFuncionario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerFuncionario(@PathVariable Long id) {
		funcionarioService.removerFuncionario(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		var funcionarios = funcionarioService.listarFuncionarios();
		return ResponseEntity.ok(funcionarios);
	}
}
