package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.repository.FuncionarioRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {
	
	@Mock
	private FuncionarioRepository funcionarioRepository;

	@InjectMocks
	private FuncionarioService funcionarioService;
	
	
	
	
}
