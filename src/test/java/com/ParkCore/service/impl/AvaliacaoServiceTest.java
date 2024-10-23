package com.ParkCore.service.impl;

import com.ParkCore.repository.AvaliacaoRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AvaliacaoServiceTest {
	
	@Mock
	private AvaliacaoRepository avaliacaoRepository;
	
	@InjectMocks
	private AvaliacaoService avaliacaoService;

	
	
}
