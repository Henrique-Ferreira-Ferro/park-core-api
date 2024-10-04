package com.ParqueCore.ParkBeto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.ParqueCore.ParkBeto.service.impl.VisitanteService;

@WebMvcTest
public class VisitanteControllerTest {

	@Mock
	private VisitanteService visitanteService;

	@InjectMocks
	private VisitanteController visitanteController;
	
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void shouldCadastrarVisitante() {
		
	}
	
	@Test
	void shouldExcluirVisitante() {
	
	}
	
}
