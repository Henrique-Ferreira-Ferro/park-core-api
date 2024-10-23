package com.ParkCore.service.impl;

import com.ParkCore.repository.FuncionarioRepository;
import com.ParkCore.service.FuncionarioServiceInterface;
import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.model.Funcionario;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements FuncionarioServiceInterface {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		if (funcionarioRepository.existsByCpf(funcionario.getCpf())) {
			throw new BadRequestException("CPF já cadastrado.");
		}
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
		var existingFuncionario = findById(id);

		existingFuncionario.setNome(funcionario.getNome());
		existingFuncionario.setCargo(funcionario.getCargo());
		existingFuncionario.setHorarioTrabalho(funcionario.getHorarioTrabalho());

		return funcionarioRepository.save(existingFuncionario);
	}

	public void removerFuncionario(Long id) {
		var funcionario = findById(id);

		funcionarioRepository.delete(funcionario);
	}

	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepository.findAll();
	}

	private Funcionario findById(Long id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Não encontrado", Funcionario.class));
	}
}
