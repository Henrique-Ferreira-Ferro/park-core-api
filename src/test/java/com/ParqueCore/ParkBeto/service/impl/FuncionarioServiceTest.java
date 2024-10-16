package com.ParqueCore.ParkBeto.service.impl;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
	
	
	
	
}
