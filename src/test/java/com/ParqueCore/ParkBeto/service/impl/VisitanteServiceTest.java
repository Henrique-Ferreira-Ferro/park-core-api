package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.VisitanteRepository;

@RunWith(MockitoJUnitRunner.class)
public class VisitanteServiceTest {
	
	@Mock
	private VisitanteRepository visitanteRepository;
	
	@InjectMocks
	private VisitanteService visitanteService;
	
	
	@Test
	public void shouldCadastrarVisitante() {
		
	}
	
	@Test 
	public void shouldExcluirVisitante() {
		
	}
	
	
}
