package com.ParqueCore.ParkBeto.controller;

import com.ParqueCore.ParkBeto.model.Funcionario;
import com.ParqueCore.ParkBeto.service.impl.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

	@Operation(summary = "Criar funcionário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso!",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Funcionario.class))),
			@ApiResponse(responseCode = "400", description = "CPF já cadastrado.")
	})
	@PostMapping
	public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		var createdFuncionario = funcionarioService.cadastrarFuncionario(funcionario);
		return new ResponseEntity<>(createdFuncionario, CREATED);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso!",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Funcionario.class)))
	})
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		var updatedFuncionario = funcionarioService.atualizarFuncionario(id, funcionario);
		return ResponseEntity.ok(updatedFuncionario);
	}

	@Operation(summary = "Exclusão de um funcionario", description = "Essa funcionalidade exclui um funcionario do sistema pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Funcionario excluído com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Funcionario não encontrado"),
			@ApiResponse(responseCode = "400", description = "Não foi possível excluir o Funcionario"),
			@ApiResponse(responseCode = "500", description = "Problema com a API!")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerFuncionario(@PathVariable Long id) {
		funcionarioService.removerFuncionario(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Buscar funcionários")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Funcionários encontrados com sucesso",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = Funcionario.class))),
	})
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		var funcionarios = funcionarioService.listarFuncionarios();
		return ResponseEntity.ok(funcionarios);
	}
}
