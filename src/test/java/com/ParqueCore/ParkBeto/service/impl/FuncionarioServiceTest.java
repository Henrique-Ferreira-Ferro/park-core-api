package com.ParqueCore.ParkBeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ParqueCore.ParkBeto.model.Funcionario;
import com.ParqueCore.ParkBeto.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {
	
	@Mock
	private FuncionarioRepository funcionarioRepository;

	@InjectMocks
	private FuncionarioService funcionarioService;
	
	@Test
	public void deveCadastrarFuncionario() {
		var funcionario = mock(Funcionario.class);
		given(funcionario.getCpf()).willReturn("13684726052");
		given(funcionarioRepository.save(funcionario)).willReturn(funcionario);
		var result = funcionarioService.cadastrarFuncionario(funcionario);
		assertEquals("13684726052", result.getCpf());
	}

	@Test
	public void deveAtualizarFuncionario() {
		// Init - Simulando o funcionário existente
		var funcionarioExistente = mock(Funcionario.class);
		given(funcionarioExistente.getId()).willReturn(1L);
		given(funcionarioExistente.getNome()).willReturn("Henrique F");
		given(funcionarioExistente.getCargo()).willReturn("Auxiliar");
		given(funcionarioExistente.getHorarioTrabalho()).willReturn(55);
		given(funcionarioRepository.save(funcionarioExistente)).willReturn(funcionarioExistente);
		// Simulação dos dados do funcionário existente
		given(funcionarioRepository.findById(1L)).willReturn(Optional.of(funcionarioExistente));
		// Init - Simulando o funcionário modificado
		//A que se dane fiquei perdido aqui. Não funciona passar funcionarioMod no given abaixo
		var funcionarioMod = mock(Funcionario.class);
		given(funcionarioExistente.getId()).willReturn(1L);
		given(funcionarioExistente.getNome()).willReturn("Henrique");
		given(funcionarioExistente.getCargo()).willReturn("Auxiliar");
		given(funcionarioExistente.getHorarioTrabalho()).willReturn(55);
		// Simulação do salvamento do funcionário modificado
		given(funcionarioRepository.save(funcionarioExistente)).willReturn(funcionarioExistente);
		// Action - Atualizar o funcionário
		var result =funcionarioService.atualizarFuncionario(1L, funcionarioMod);
		assertEquals(1L, result.getId());
		assertEquals("Henrique", result.getNome());
		assertEquals("Auxiliar", result.getCargo());
		assertEquals(55, result.getHorarioTrabalho());
	}

	@Test
	public void deveRemoverFuncionario(){
		var funcionario = mock(Funcionario.class);
		given(funcionario.getId()).willReturn(1L);
		given(funcionarioRepository.findById(funcionario.getId())).willReturn(Optional.of(funcionario));
		funcionarioService.removerFuncionario(1L);
	}

	@Test
	public void deveListarFuncionarios(){
		var funcionario = mock(Funcionario.class);
		var funcionario2 = mock(Funcionario.class);
		var funcionario3 = mock(Funcionario.class);
		given(funcionarioRepository.findAll()).willReturn(List.of(funcionario,funcionario2,funcionario3));
		funcionarioService.listarFuncionarios();
	}

	@Test
	public void deveLancarExcecaoQuandoHouverCpfJaCadastrado(){
		var funcionario = mock(Funcionario.class);
		given(funcionario.getCpf()).willReturn("13684726052");
		given(funcionarioRepository.existsByCpf("13684726052")).willReturn(true);
		thenThrownBy(() -> funcionarioService.cadastrarFuncionario(funcionario)).isInstanceOf(RuntimeException.class);
	}
	
}
