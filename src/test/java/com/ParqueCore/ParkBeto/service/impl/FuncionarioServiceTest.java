package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.FuncionarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class FuncionarioServiceTest {
	
	@Mock
	private FuncionarioRepository funcionarioRepository;

	@InjectMocks
	private FuncionarioService funcionarioService;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
}
