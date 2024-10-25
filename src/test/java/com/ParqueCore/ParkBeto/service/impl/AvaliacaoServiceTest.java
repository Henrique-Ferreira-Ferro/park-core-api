package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.repository.AvaliacaoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AvaliacaoServiceTest {
	
	@Mock
	private AvaliacaoRepository avaliacaoRepository;
	
	@InjectMocks
	private AvaliacaoService avaliacaoService;

	
	
}
