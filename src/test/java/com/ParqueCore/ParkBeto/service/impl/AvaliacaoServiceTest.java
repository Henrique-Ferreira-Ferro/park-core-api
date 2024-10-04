package com.ParqueCore.ParkBeto.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ParqueCore.ParkBeto.repository.AvaliacaoRepository;

@RunWith(MockitoJUnitRunner.class)
public class AvaliacaoServiceTest {
	
	@Mock
	private AvaliacaoRepository avaliacaoRepository;
	
	@InjectMocks
	private AvaliacaoService avaliacaoService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
}
